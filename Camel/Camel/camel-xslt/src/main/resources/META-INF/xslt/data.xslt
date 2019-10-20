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
                    <xsl:apply-templates select="project/dependencies/dependency"/>
                </ul>
            </body>
        </html>
    </xsl:template>

    <!-- match a <messageBoard> element -->
    <xsl:template match="/dependency">
        <ul>
            <li>                
                <xsl:value-of select="@groupId"/>
            </li>
            <li>                
                <xsl:value-of select="@artifactId"/>
            </li>
            <li>                
                <xsl:value-of select="@version"/>
            </li>
        </ul>
    </xsl:template>
</xsl:stylesheet>
