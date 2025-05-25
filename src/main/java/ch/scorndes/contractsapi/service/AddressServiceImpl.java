package ch.scorndes.contractsapi.service;

import ch.scorndes.contractsapi.dto.AddressDto;
import ch.scorndes.contractsapi.mapper.AddressMapper;
import ch.scorndes.contractsapi.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
        private final AddressRepository addressRepository;
        private final AddressMapper addressMapper;

        public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
            this.addressMapper = addressMapper;
            this.addressRepository = addressRepository;
        }

        @Override
        public List<AddressDto> getAddressesByUserId(UUID id) {
            return addressRepository.findByUserId(id).stream().map(addressMapper::toDto).collect(Collectors.toList());
        }

}
