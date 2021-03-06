package com.microsoft.bingads.v10.api.test.entities.targets.campaign.bids.radius.read;

import com.microsoft.bingads.v10.api.test.entities.targets.campaign.bids.radius.BulkCampaignRadiusTargetBidTest;
import com.microsoft.bingads.v10.bulk.entities.BulkCampaignRadiusTargetBid;
import com.microsoft.bingads.v10.campaignmanagement.IntentOption;
import com.microsoft.bingads.internal.functionalinterfaces.Function;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BulkCampaignRadiusTargetReadFromRowValuesPhysicalIntentTest extends BulkCampaignRadiusTargetBidTest {

    @Parameter(value = 1)
    public IntentOption expectedResult;
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"PeopleIn", IntentOption.PEOPLE_IN},
            {"PeopleInOrSearchingForOrViewingPages", IntentOption.PEOPLE_IN_OR_SEARCHING_FOR_OR_VIEWING_PAGES},
            {"PeopleSearchingForOrViewingPages", IntentOption.PEOPLE_SEARCHING_FOR_OR_VIEWING_PAGES}
        });
    }

    @Test
    public void testRead() {
        this.<IntentOption>testReadProperty("Physical Intent", this.datum, this.expectedResult, new Function<BulkCampaignRadiusTargetBid, IntentOption>() {
            @Override
            public IntentOption apply(BulkCampaignRadiusTargetBid c) {
                return c.getIntentOption();
            }
        });
    }        
}
