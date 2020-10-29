package io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.service.impl.AllBuildersImpl;
import io.github.williamjesusdev.grupojsa.core.exception.ResourceNotFoundException;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Contrato;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.AlugueisRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.repository.ContratosRepository;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.service.AluguelService;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.requests.AluguelRequestDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.AluguelResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelServiceImpl extends AllBuildersImpl implements AluguelService {
    @Autowired
    private AlugueisRepository alugueisRepository;
    @Autowired
    private ContratosRepository contratosRepository;

    @Override
    public List<AluguelResponseDTO> getAllAlugueis(){
        List<Aluguel> alugueis = alugueisRepository.findAll();

        return alugueis
                .stream()
                .map(this::buildToAluguelResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AluguelResponseDTO getAluguelById(Long id){
        Aluguel aluguel = alugueisRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não lançado"));

        return buildToAluguelResponseDTO(aluguel);
    }

    @Override
    public List<AluguelResponseDTO> getAllAlugueisByRecibo(Long recibo){
        List<Aluguel> alugueis = alugueisRepository
                .findByRecibo(recibo);

        if(alugueis.isEmpty()){
            throw  new ResourceNotFoundException("Recibo não encontrado");
        }

        return alugueis
                .stream()
                .map(this::buildToAluguelResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AluguelResponseDTO> getAllAlugueisByMes(Integer mes){
       List<Aluguel> alugueis = alugueisRepository.getAllAlugueisByMes(mes);

        return alugueis
                .stream()
                .map(this::buildToAluguelResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Aluguel createAluguel(AluguelRequestDTO aluguelRequestDTO) {
        List<Aluguel> alugueis = alugueisRepository.findByRecibo(aluguelRequestDTO.getRecibo());
        Contrato contrato = contratosRepository
                .findById(aluguelRequestDTO.getContrato())
                .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado"));

        if(!alugueis.isEmpty()){
            throw  new ResourceNotFoundException("Recibo já cadastrado");
        }

        Aluguel aluguel = new Aluguel(aluguelRequestDTO, contrato);

        return alugueisRepository.save(aluguel);
    }
}
