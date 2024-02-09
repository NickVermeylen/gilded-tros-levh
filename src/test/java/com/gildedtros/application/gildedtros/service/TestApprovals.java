package com.gildedtros.application.gildedtros.service;

import com.gildedtros.TexttestFixture;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class TestApprovals {
    @Test
    void fifty_days() {
        Approvals.verify(TexttestFixture.testDays(50));
    }
}
