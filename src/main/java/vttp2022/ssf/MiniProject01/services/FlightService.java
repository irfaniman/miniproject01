package vttp2022.ssf.MiniProject01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.ssf.MiniProject01.models.RealTimeInfo;
import vttp2022.ssf.MiniProject01.repositories.RealTimeRepository;

@Service
public class FlightService {

	@Autowired
	private RealTimeRepository realTimeRepo;

	public void save(List<RealTimeInfo> toSave) {
		realTimeRepo.save(toSave);
	}

	public Optional<RealTimeInfo> get(String reg_number) {
		return realTimeRepo.get(reg_number);
	}

}
