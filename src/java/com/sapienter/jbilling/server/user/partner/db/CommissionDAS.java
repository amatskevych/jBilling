/*
jBilling - The Enterprise Open Source Billing System
Copyright (C) 2003-2011 Enterprise jBilling Software Ltd. and Emiliano Conde

This file is part of jbilling.

jbilling is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

jbilling is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with jbilling.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.sapienter.jbilling.server.user.partner.db;

import com.sapienter.jbilling.server.util.db.AbstractDAS;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommissionDAS extends AbstractDAS<CommissionDTO> {
    
    public List<CommissionDTO> findAllByProcessRun(CommissionProcessRunDTO commissionProcessRun, Integer entityId){
        Criteria criteria = getSession().createCriteria(CommissionDTO.class)
                .add(Restrictions.eq("commissionProcessRun", commissionProcessRun))
                .createAlias("commissionProcessRun", "_commissionProcessRun")
                .createAlias("_commissionProcessRun.entity", "_entity")
                .add(Restrictions.eq("_entity.id", entityId))
                .addOrder(Order.desc("id"));

        return criteria.list();
    }
}
