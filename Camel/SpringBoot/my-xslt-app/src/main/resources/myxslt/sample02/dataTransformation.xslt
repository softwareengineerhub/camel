<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>


    <!-- match the document root -->
    <xsl:template match="/">
        <html>
            <head>
                <title>School Forum Home Page</title>
            </head>
            <body>                
                <xsl:apply-templates select="school"/>                
            </body>
        </html>
    </xsl:template>

    <!-- match a <messageBoard> element -->
    <xsl:template match="school">
        <p>
            <xsl:value-of select="name" /> is located in 
            <xsl:value-of select="city" />, 
            <xsl:value-of select="state" />.
        </p>
    </xsl:template>
</xsl:stylesheet>
