package org.ugguss.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.Contribution;
import org.ugguss.model.GussMemberContribution;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-21T22:04:23-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class ContributionServiceMapperUtilImpl implements ContributionServiceMapperUtil {

    @Override
    public GussMemberContribution contributionDTOtoDbContribution(Contribution contribution) {
        if ( contribution == null ) {
            return null;
        }

        GussMemberContribution gussMemberContribution = new GussMemberContribution();

        gussMemberContribution.setComments( contribution.getComments() );
        gussMemberContribution.setDocId( contribution.getDocumentId() );
        gussMemberContribution.setFiscalMonth( contribution.getFiscalMonth() );
        try {
            if ( contribution.getPaymentDate() != null ) {
                gussMemberContribution.setPaymentDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( contribution.getPaymentDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        gussMemberContribution.setFiscalYear( contribution.getFiscalYear() );
        gussMemberContribution.setContributionCategory( contribution.getContributionCategory() );
        try {
            if ( contribution.getDateCreated() != null ) {
                gussMemberContribution.setDateCreated( new SimpleDateFormat().parse( contribution.getDateCreated() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return gussMemberContribution;
    }

    @Override
    public Contribution dbContributionToDTOcontribution(GussMemberContribution gussMemberContribution) {
        if ( gussMemberContribution == null ) {
            return null;
        }

        Contribution contribution = new Contribution();

        contribution.setComments( gussMemberContribution.getComments() );
        contribution.setDocumentId( gussMemberContribution.getDocId() );
        contribution.setFiscalMonth( gussMemberContribution.getFiscalMonth() );
        if ( gussMemberContribution.getPaymentDate() != null ) {
            contribution.setPaymentDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( gussMemberContribution.getPaymentDate() ) );
        }
        contribution.setFiscalYear( gussMemberContribution.getFiscalYear() );
        contribution.setContributionCategory( gussMemberContribution.getContributionCategory() );
        if ( gussMemberContribution.getDateCreated() != null ) {
            contribution.setDateCreated( new SimpleDateFormat().format( gussMemberContribution.getDateCreated() ) );
        }

        return contribution;
    }
}
