package umc.umcspring.service.LocationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umcspring.repository.LocationRepository;

@Service
@RequiredArgsConstructor
public class LocationQueryServiceImpl implements LocationQueryService{
    private final LocationRepository locationRepository;

    @Override
    public boolean isLocationExist(Long locationId) {
        return locationRepository.existsById(locationId);
    }
}
