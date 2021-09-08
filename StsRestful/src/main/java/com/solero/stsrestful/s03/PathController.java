/*
 * ParhVariable
 */
package com.solero.stsrestful.s03;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathv/*")
public class PathController {
	// http://localhost:8090/stsrestful/pathv/events/114
	@RequestMapping(value="/events/{num}", method=RequestMethod.GET)
	public String eventsNum(@PathVariable("num") int num) throws Exception {
		String result = String.format("[/events/%d]", num);
		return result;
	}
	
	@RequestMapping(value="/events/command/{command}", method=RequestMethod.GET)
	public String eventsCommand(@PathVariable("command") String command) throws Exception {
		String result = String.format("[/events/command/%s]", command);
		return result;
	}
}
