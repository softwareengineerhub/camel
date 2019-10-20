/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.camel.xslt.fromfile;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author dprokopiuk
 */
public class FileReadRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .process(new LogProcessor())
                .process(new ReadXmlProcessor())                
                .to("xslt:discussionForumHome.xslt")
                //.to("xslt:discussionForumHome.xslt?transformerFactory=tFactory&saxon=true")
                .process(new AfterXsltProcessor());
                //.to("xslt:data/input/discussionForumHome.xslt");
    }
///org.apache.xalan.xsltc.trax.TransformerFactoryImpl
}
