package uni.tehran.repository;

import uni.tehran.comman.ConnectionPool;
import uni.tehran.comman.exception.RecordNotFindException;
import uni.tehran.model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UnitDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public  UnitDA() throws Exception {
        connection= ConnectionPool.getConnection();
    }

    public void insert(Unit unit)throws Exception{
        preparedStatement=connection.prepareStatement("select unit_seq.nextval id from dual");
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        unit.setId(resultSet.getLong("id"));
        preparedStatement=connection.prepareStatement("insert into unit (id,unitId,unitOwner,tenantName,rentCost,paymentAmount,balance) values (?,?,?,?,?,?,?)");
        preparedStatement.setLong(1,unit.getId());
        preparedStatement.setLong(2,unit.getUnitId());
        preparedStatement.setString(3,unit.getUnitOwner());
        preparedStatement.setString(4, unit.getTenantName());
        preparedStatement.setLong(5,unit.getRentCost());
        preparedStatement.setLong(6,unit.getPaymentAmount());
        preparedStatement.setLong(7,unit.getBalance());
        preparedStatement.execute();
    }

    public void update(Unit unit) throws Exception{
        preparedStatement=connection.prepareStatement("update unit set tenantNam=?,rentCodt=?,paymentAmount=?,balance=? where uniteId=? ");
        preparedStatement.setString(1, unit.getTenantName());
        preparedStatement.setLong(2,unit.getRentCost());
        preparedStatement.setLong(3,unit.getPaymentAmount());
        preparedStatement.setLong(4,unit.getBalance());
        preparedStatement.setLong(5,unit.getUnitId());
        preparedStatement.execute();
    }

    public void delete (Unit unit) throws Exception {
        preparedStatement=connection.prepareStatement("delete unit where unitId = ?");
        preparedStatement.setLong(1,unit.getUnitId());
        preparedStatement.execute();
    }

    public Unit selectOne(Unit unit) throws Exception {
        preparedStatement=connection.prepareStatement("select * from unit where unitId=?");
        preparedStatement.setLong(1,unit.getUnitId());
        ResultSet resultSet=preparedStatement.executeQuery();
        if (resultSet.next()){
            unit.setUnitOwner(resultSet.getString("unitOwner"));
            unit.setTenantName(resultSet.getString("tenantName"));
            unit.setRentCost(resultSet.getLong("rentCost"));
            unit.setPaymentAmount(resultSet.getLong("paymentAmount"));
            unit.setBalance(resultSet.getLong("balance"));
            return unit;
        }
        throw new RecordNotFindException();
    }

    public List<Unit> selectAll() throws Exception{
        preparedStatement=connection.prepareStatement("select * from unit");
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Unit> unitList=new ArrayList<>();
        while (resultSet.next()){
            Unit unit =new Unit().setUnitId(resultSet.getLong("unitId"))
                    .setUnitOwner(resultSet.getString("unitOwner"))
                    .setTenantName(resultSet.getString("tenantName"))
                    .setRentCost(resultSet.getLong("rentCost"))
                    .setPaymentAmount(resultSet.getLong("paymentAmount"))
                    .setBalance(resultSet.getLong("balance"));
            unitList.add(unit);
        }
        return unitList ;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    @Override
    public void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }


}
