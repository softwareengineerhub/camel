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
                    <xsl:apply-templates select="discussionForumHome/body/eventSide"/>
                </ul>
            </body>
        </html>
    </xsl:template>
    
    
    <!-- match a <clearingDetail> element -->
    <xsl:template match="discussionForumHome/body/eventSide">
        <xsl:for-each select="clearingDetail">
        <li>
            <a>
                <xsl:value-of select="./clearingStatus"/>
            </a>
        </li>
        </xsl:for-each>
    </xsl:template>
    

    <!-- match a <messageBoard> element -->
    <xsl:template match="discussionForumHome/body">
        <xsl:for-each select="messageBoard">
        <li>
            <a>
                <xsl:value-of select="."/>
            </a>
        </li>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
