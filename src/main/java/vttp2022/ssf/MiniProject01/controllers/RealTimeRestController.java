package vttp2022.ssf.MiniProject01.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.ssf.MiniProject01.models.RealTimeInfo;
import vttp2022.ssf.MiniProject01.services.RealTimeService;

@RestController
@RequestMapping(path = "/rest/realTimeFlights", produces = MediaType.APPLICATION_JSON_VALUE)
public class RealTimeRestController {

	@Autowired
	private RealTimeService realTimeSvc;

	@GetMapping(path="{reg_number}")
	public ResponseEntity<String> getFlights(@PathVariable(name="reg_number") String reg_number) {
		Optional<RealTimeInfo> opt = realTimeSvc.get(reg_number);
		if (opt.isEmpty()) {
			JsonObject payload = Json.createObjectBuilder()
				.add("error", "Cannot find flight %s".formatted(reg_number))
				.build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(payload.toString());
		}
		RealTimeInfo flights = opt.get();
		return ResponseEntity.ok(flights.toJson().toString());
	}

}
