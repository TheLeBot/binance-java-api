package com.binance.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum UniversalTransferType {
    MAIN_UMFUTURE("Spot account transfer to USDⓈ-M Futures account"),
    MAIN_CMFUTURE("Spot account transfer to COIN-M Futures account"),
    MAIN_MARGIN("Spot account transfer to Margin（cross）account"),
    UMFUTURE_MAIN("USDⓈ-M Futures account transfer to Spot account"),
    UMFUTURE_MARGIN("USDⓈ-M Futures account transfer to Margin（cross）account"),
    CMFUTURE_MAIN("COIN-M Futures account transfer to Spot account"),
    CMFUTURE_MARGIN("COIN-M Futures account transfer to Margin(cross) account"),
    MARGIN_MAIN("Margin（cross）account transfer to Spot account"),
    MARGIN_UMFUTURE("Margin（cross）account transfer to USDⓈ-M Futures"),
    MARGIN_CMFUTURE("Margin（cross）account transfer to COIN-M Futures"),
    ISOLATEDMARGIN_MARGIN("Isolated margin account transfer to Margin(cross) account"),
    MARGIN_ISOLATEDMARGIN("Margin(cross) account transfer to Isolated margin account"),
    ISOLATEDMARGIN_ISOLATEDMARGIN("Isolated margin account transfer to Isolated margin account"),
    MAIN_FUNDING("Spot account transfer to Funding account"),
    FUNDING_MAIN("Funding account transfer to Spot account"),
    FUNDING_UMFUTURE("Funding account transfer to UMFUTURE account"),
    UMFUTURE_FUNDING("UMFUTURE account transfer to Funding account"),
    MARGIN_FUNDING("MARGIN account transfer to Funding account"),
    FUNDING_MARGIN("Funding account transfer to Margin account"),
    FUNDING_CMFUTURE("Funding account transfer to CMFUTURE account"),
    CMFUTURE_FUNDING("CMFUTURE account transfer to Funding account");

    private String transferDescription;

    UniversalTransferType(String psDescription) {
        this.transferDescription = psDescription;
    }

    /**
     * Returns description for the transfer type
     *
     * @return String
     */
    public String getTransferDescription() { return this.transferDescription; }

    @Override
    public String toString() {
        return this.name();
    }
}