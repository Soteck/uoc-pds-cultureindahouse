package org.uoc.pds.alpha.cultureindahouse.ejb.repository;

import javax.ejb.Local;

import org.uoc.pds.alpha.cultureindahouse.ejb.base.BaseRepository;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.OrderHistory;

@Local
public interface OrderHistoryRepositoryInterface extends BaseRepository<OrderHistory> {
}
