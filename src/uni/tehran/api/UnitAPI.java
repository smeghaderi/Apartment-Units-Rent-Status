package uni.tehran.api;


import uni.tehran.comman.ExceptionWrapper;
import uni.tehran.model.Unit;
import uni.tehran.service.UnitService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/unit")
public class UnitAPI {

    @GET
    @Produces("application/json")
    @Path("/save")
    public Object save(@QueryParam("unitId") String unitId,@QueryParam("unitOwner") String unitOwner,@QueryParam("tenantName") String tenantName,@QueryParam("rentCost") String rentCost,@QueryParam("paymentAmount") String paymentAmount,@QueryParam("paymentMethod") String paymentMethod){
        try{
            Unit unit = new Unit(Long.parseLong(unitId),unitOwner,tenantName,Long.parseLong(rentCost),Long.parseLong(paymentAmount),Boolean.parseBoolean(paymentMethod));
            UnitService.getInstance().save(unit);
            return unit ;
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }

    @GET
    @Produces("application/json")
    @Path("/update")
    public Object update(@QueryParam("unitId") String unitId ,@QueryParam("paymentAmount") String paymentAmount)
    {
        try {
            Unit unit = new Unit(Long.parseLong(unitId),Long.parseLong(paymentAmount));
            UnitService.getInstance().update(unit);
            return unit ;
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }

    @GET
    @Produces("application/json")
    @Path("/remove")
    public Object remove(@QueryParam("unitId") String unitId){
        try {
            Unit unit = new Unit().setUnitId(Long.parseLong(unitId));
            UnitService.getInstance().remove(unit);
            return findAll();
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }

    @GET
    @Produces("application/json")
    @Path("/findOne")
    public Object findOne(@QueryParam("unitId") String unitId){
        try{
            Unit unit = new Unit().setUnitId(Long.parseLong(unitId));
            return UnitService.getInstance().findOne(unit);
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }

    @GET
    @Produces("application/json")
    @Path("/findAll")
    public Object findAll(){
        try{
            return UnitService.getInstance().findAll();
        }catch (Exception e){
            return ExceptionWrapper.getError(e);
        }
    }
}
