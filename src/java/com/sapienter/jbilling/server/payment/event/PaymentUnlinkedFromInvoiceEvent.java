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

package com.sapienter.jbilling.server.payment.event;

import com.sapienter.jbilling.server.invoice.db.InvoiceDTO;
import com.sapienter.jbilling.server.payment.PaymentDTOEx;

import java.math.BigDecimal;

public class PaymentUnlinkedFromInvoiceEvent extends AbstractPaymentEvent {
    InvoiceDTO invoice;
    BigDecimal totalPaid;

    public PaymentUnlinkedFromInvoiceEvent(Integer entityId, PaymentDTOEx payment) {
        super(entityId, payment);
    }

    public PaymentUnlinkedFromInvoiceEvent(Integer entityId, PaymentDTOEx payment, InvoiceDTO invoice, BigDecimal totalPaid) {
        this(entityId, payment);
        this.invoice = invoice;
        this.totalPaid = totalPaid;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public InvoiceDTO getInvoice() {
        return invoice;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    @Override
    public String toString() {
        Integer paymentId = (getPayment() != null) ? getPayment().getId() : null;
        Integer invoiceId = (getInvoice() != null) ? getInvoice().getId() : null;

        return "PaymentUnlinkedFromInvoiceEvent{"
                + "paymentId=" + paymentId
                + ", amount=" + getPayment().getAmount()
                + ", invoiceId=" + invoiceId
                + "}";
    }

}
