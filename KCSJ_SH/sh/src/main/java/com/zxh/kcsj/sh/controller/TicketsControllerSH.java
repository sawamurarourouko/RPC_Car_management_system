package com.zxh.kcsj.sh.controller;



import com.zxh.kcsj.sh.service.CarsService;
import com.zxh.kcsj.sh.service.TicketsService;
import model.TicketsModel;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/TicketSH")
public class TicketsControllerSH {
    public final TicketsService ticketsService;
    public final CarsService carsService;

    public TicketsControllerSH(TicketsService ticketsService,CarsService carsService) {
        this.ticketsService = ticketsService;
        this.carsService = carsService;
    }

    @RequestMapping(value = "/getAllTct")
    @ResponseBody
    public List<TicketsModel> getAllTct(){
        return ticketsService.getAllTct();
    }

    @RequestMapping(value = "/getUsrTct")
    @ResponseBody
    public List<TicketsModel> getUsrTct(String uid){
        return ticketsService.getUserTct(uid);
    }

    @RequestMapping(value = "/getUTNow")
    @ResponseBody
    public List<TicketsModel> getUTNow(String uid) { return ticketsService.getUTNow(uid); }

    @RequestMapping(value = "/getUTHistory")
    @ResponseBody
    public List<TicketsModel> getUTHisory(String uid) { return ticketsService.getUTHistory(uid); }

    @RequestMapping(value = "/addTct")
    @ResponseBody
    public String addTicket(String reason,String time,int charge,String cid,String pid,String state,String city,String uid) {
        if (ticketsService.addTct(reason, time, charge, cid, pid, state, city, uid) > 0)
            return "添加成功";
        else
            return "添加失败";
    }

    @RequestMapping(value = "/updateTct")
    @ResponseBody
    public Boolean updateTicket(int id,String reason,String time,int charge,String cid,String pid,String state,String city){
        if(ticketsService.updateTct(id, reason, time, charge, cid, pid, state, city)>0)
            return true;
        else
            return false;
    }

}
