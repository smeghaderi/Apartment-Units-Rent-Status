package uni.tehran.service;

import uni.tehran.model.Unit;
import uni.tehran.repository.UnitDA;

import java.util.List;

public class UnitService {
    private static final UnitService UNIT_SERVICE = new UnitService();

    public UnitService() {
    }

    public static UnitService getInstance() throws Exception {
        return UNIT_SERVICE ;
    }

    public void save(Unit unit)throws Exception {
        try(UnitDA unitDA = new UnitDA()){
            if (unit.isPaymentMethode() == true){
                unit.setPaymentAmount(unit.getRentCost()*11);
                unit.setBalance(0);
            }
            else {
                unit.setBalance(unit.getPaymentAmount()-(unit.getRentCost()*12));
            }
            unitDA.insert(unit);
            unitDA.commit();
        }
    }

    public void update(Unit unit) throws Exception {
        try(UnitDA unitDA = new UnitDA()){
            unit.setBalance(unit.getPaymentAmount()+unitDA.selectOne(unit).getBalance());
            unit.setPaymentAmount(unit.getPaymentAmount()+unitDA.selectOne(unit).getPaymentAmount());
            unitDA.update(unit);
            unitDA.commit();
        }
    }

    public void remove(Unit unit) throws Exception {
        try(UnitDA unitDA = new UnitDA()){
            unitDA.delete(unit);
            unitDA.commit();
        }
    }

    public Unit findOne(Unit unit) throws Exception {
        try(UnitDA unitDA = new UnitDA()){
            return unitDA.selectOne(unit);
        }
    }

    public List<Unit> findAll() throws Exception{
        try(UnitDA unitDA= new UnitDA()) {
            return unitDA.selectAll();
        }
    }
}
