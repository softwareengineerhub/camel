<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:env="http://schemas.xmlsoap.org/soap/envelope/"
                xmlns:mtc="OTC_Matching_FX_2-1"
                xmlns:fpml="http://www.fpml.org/FpML-5/confirmation"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:mcp="http://www.markit.com/processing/mcp/core/normalised/messaging/envelope"
                xmlns:es="http://www.markit.com/processing/mcp/core/normalised/trade/events"
                xmlns:ns4="http://www.markit.com/processing/mcp/core/normalised/trade/events"
                exclude-result-prefixes="xs mcp es" version="2.0">
    <xsl:output method="xml" indent="yes" standalone="yes"/>

    <xsl:template name="generateReceivedFpML">
        <ns2:Envelope xmlns:ns2="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns3="OTC_Matching_FX_2-1" xmlns:ns4="http://www.fpml.org/FpML-5/confirmation" xmlns:ns5="http://www.w3.org/2000/09/xmldsig#">
            <ns2:Body>
                <ns3:OTC_Matching xmlns="OTC_Matching_FX_2-1">                    
                    <ns4:clearingAcknowledgement>
                        <ns4:header></ns4:header>
                        <ns4:messageId messageIdScheme="http://www.fxglobalclear.com/coding-scheme/clearer/message-id">rawFpMLMessageId</ns4:messageId>
                        <ns4:inReplyTo messageIdScheme="http://www.fxglobalclear.com/coding-scheme/clearer/message-id">n/a</ns4:inReplyTo>
                        <ns4:sentBy messageAddressScheme="http://www.fpml.org/ext/iso9362">ccpandrawOriginatorId</ns4:sentBy>
                        <ns4:creationTimestamp>fpmlMessageCreationTimestamp</ns4:creationTimestamp>
       
                        <xsl:apply-templates select="MCPMsgEnvelope"></xsl:apply-templates>
                           <!-- <xsl:value-of select="mcp:MCPMsgEnvelope/mcp:body/mcp:eventSide/mcp:clearingDetail/mcp:clearingStatus"/>matchId-->
       
                    </ns4:clearingAcknowledgement>                                       
                </ns3:OTC_Matching>
            </ns2:Body>
        </ns2:Envelope>          
    </xsl:template>


    <xsl:template match="MCPMsgEnvelope">                     
        <p>www</p>
        
        <xsl:for-each select="MCPMsgEnvelope/body">
            <p>aaa</p>
        </xsl:for-each>
        
        
        
        <xsl:for-each select="mcp:body">
            <p>qqqqqqqqqqqqqqqqqqq</p>        
            <ns4:correlationId correlationIdScheme="http://www.fxglobalclear.com/coding-scheme/matcher/matching-id">
                <!--<xsl:apply-templates select="MCPMsgEnvelope/body/eventSide/clearingDetail/clearingStatus"></xsl:apply-templates>-->
                <xsl:value-of select="/mcp:body/mcp:eventSide/mcp:clearingDetail/mcp:clearingStatus"/>matchId
            </ns4:correlationId>
       
        </xsl:for-each>
    </xsl:template>

   <!-- catalog/cd/artist -->

    
    <xsl:template name="main" match="/">
        <xsl:call-template name="generateReceivedFpML"/>
    </xsl:template>
</xsl:stylesheet>