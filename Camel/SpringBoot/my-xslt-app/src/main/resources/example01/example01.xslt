<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>


    <!-- match the document root -->
    <xsl:template match="/">
        <html>
            <head>
                <title>Discussion Forum Home Page</title>
            </head>
            <body>
                <h1>Discussion Forum Home Page</h1>
                <h3>Please select a message board to view:</h3>                
                <ul>
                    <xsl:apply-templates select="Tutorials/Tutorial"/>
                </ul>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="Tutorial">                        
        <xsl:variable name="a1" select="title"/>
        <xsl:variable name="b" select="'bValue'"/>
        <xsl:variable name="c" select=""/>        
        <br/>                
        
        <xsl:if test="$a1 = 'XML'">
            <br/>                
            <xsl:value-of select="$a1"/>
        </xsl:if>
        
        <xsl:if test="$b != ''">
            <NOT_EMPTY/>                
            <!-- <xsl:value-of select="###NOT EMPTY###"/> -->
        </xsl:if>
        
        <xsl:if test="$c = ''">
            <EMPTY/>                
            <!-- <xsl:value-of select="###EMPTY###"/> -->
        </xsl:if>
        
        <xsl:if test="($a1 = 'XML') and ($b != '') and ($c = '') ">
            <AND/>                
        </xsl:if>
        
        
        <xsl:if test="($a1 != 'XML') or ($b != 'WWW') or ($c = '') ">
            <OR/>                
        </xsl:if>
        
    </xsl:template>
    
    <xsl:template match="Tutorial_Many">                
        <!-- <xsl:variable name="a" select="'descendant::mcp:MCPMsgEnvelope/mcp:body/es:eventSide/es:interestedParty[es:role='Counterparty'][es:referenceId=$target]/parent::node()'"/> -->
        <xsl:variable name="a1" select="title"/>
        <xsl:variable name="b" select="'bValue'"/>
        <xsl:variable name="c" select="'cValue'"/>        
        <br/>                
        <!-- <xsl:value-of select="$a"/> -->
        <br/>                
        <xsl:value-of select="$a1"/>
        <br/>                
        <xsl:value-of select="$b"/>
        <br/>                
        <xsl:value-of select="$c"/>
    </xsl:template>
    
</xsl:stylesheet>
