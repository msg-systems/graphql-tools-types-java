/*******************************************************************************
 * *
 * **  Design and Development by msg Applied Technology Research
 * **  Copyright (c) 2019-2020 msg systems ag (http://www.msg-systems.com/)
 * **  All Rights Reserved.
 * ** 
 * **  Permission is hereby granted, free of charge, to any person obtaining
 * **  a copy of this software and associated documentation files (the
 * **  "Software"), to deal in the Software without restriction, including
 * **  without limitation the rights to use, copy, modify, merge, publish,
 * **  distribute, sublicense, and/or sell copies of the Software, and to
 * **  permit persons to whom the Software is furnished to do so, subject to
 * **  the following conditions:
 * **
 * **  The above copyright notice and this permission notice shall be included
 * **  in all copies or substantial portions of the Software.
 * **
 * **  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * **  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * **  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * **  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * **  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * **  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * **  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * *
 ******************************************************************************/
package com.thinkenterprise.gtt.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thinkenterprise.gtt.types.GttDateType;
import com.thinkenterprise.gtt.types.GttJsonType;
import com.thinkenterprise.gtt.types.GttUuidType;
import com.thinkenterprise.gtt.types.GttVoidType;

/**
 * Class used to process any incoming message sent by clients via WebSocket
 * supports subprotocols (CBOR, MsgPack, Text)
 * triggers process to indicate outdating queries and notifies clients
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 */

@Configuration
@EnableConfigurationProperties(GttAutoConfiguration.class)
@ConfigurationProperties(prefix = "graphqlio.toolstypes")
public class GttAutoConfiguration{

	@Autowired
	private GttProperties gttProperties;
    	
	@Bean 
	public GttUuidType gttUuidType() { return new GttUuidType(); }
	
	@Bean 
	public GttDateType gttDateType() { return new GttDateType(); }

	@Bean 
	public GttJsonType gttJsonType() { return new GttJsonType(); }

	@Bean 
	public GttVoidType gttVoidType() { return new GttVoidType(); }
	
}