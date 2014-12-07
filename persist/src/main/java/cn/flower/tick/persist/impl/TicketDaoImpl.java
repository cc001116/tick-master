package cn.flower.tick.persist.impl;

import org.springframework.stereotype.Repository;

import cn.flower.tick.model.biz.Ticket;
import cn.flower.tick.persist.ITicketDao;

@Repository
public class TicketDaoImpl extends CommonDaoImpl<Ticket> implements ITicketDao {

}
