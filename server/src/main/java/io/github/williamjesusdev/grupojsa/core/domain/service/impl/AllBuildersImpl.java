package io.github.williamjesusdev.grupojsa.core.domain.service.impl;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
import io.github.williamjesusdev.grupojsa.core.domain.service.AllBuilders;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.CidadeResponseDTO;
import io.github.williamjesusdev.grupojsa.core.rest.dto.responses.EstadoResponseDTO;
import io.github.williamjesusdev.grupojsa.empresa.domain.entity.Empresa;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.EmpresaResponseDTO;
import io.github.williamjesusdev.grupojsa.empresa.rest.dto.responses.ResumoEmpresaResponseDTO;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Aluguel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Contrato;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Imovel;
import io.github.williamjesusdev.grupojsa.imobiliaria.domain.entity.Locatario;
import io.github.williamjesusdev.grupojsa.imobiliaria.rest.dto.responses.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllBuildersImpl implements AllBuilders {

    @Override
    public EstadoResponseDTO buildToEstadoResponseDTO(Estado estado) {
        return EstadoResponseDTO
                .builder()
                .id(estado.getId())
                .nome(estado.getNome())
                .sigla(estado.getSigla())
                .cidades(estado.getCidades()
                        .stream()
                        .map(this::buildToCidadeResponseDTO)
                        .collect(Collectors.toList())
                ).build();
    }

    @Override
    public CidadeResponseDTO buildToCidadeResponseDTO(Cidade cidade) {
        return CidadeResponseDTO
                .builder()
                .id(cidade.getId())
                .nome(cidade.getNome())
                .estado(cidade.getEstado().getSigla())
                .empresas(cidade.getEmpresas()
                        .stream()
                        .map(this::buildToResumoEmpresaDTO)
                        .collect(Collectors.toList())
                ).build();
    }

    @Override
    public EmpresaResponseDTO buildToEmpresaResponseDTO(Empresa empresa) {
        return EmpresaResponseDTO
                .builder()
                .id(empresa.getId())
                .razao(empresa.getRazao())
                .fantasia(empresa.getFantasia())
                .cnpj(empresa.getCnpj())
                .ie(empresa.getIe())
                .telefone(empresa.getTelefone())
                .email(empresa.getEmail())
                .endereco(empresa.getEndereco())
                .numero(empresa.getNumero())
                .bairro(empresa.getBairro())
                .complemento(empresa.getComplemento())
                .cep(empresa.getCep())
                .cidade(buildToCidadeResponseDTO(empresa.getCidade()))
                .build();
    }

    @Override
    public ResumoEmpresaResponseDTO buildToResumoEmpresaDTO(Empresa empresa) {
        return ResumoEmpresaResponseDTO
                .builder()
                .id(empresa.getId())
                .razao(empresa.getRazao())
                .fantasia(empresa.getFantasia())
                .cnpj(empresa.getCnpj())
                .build();
    }

    @Override
    public LocatarioResponseDTO buildToLocatarioResponseDTO(Locatario locatario) {
        return LocatarioResponseDTO
                .builder()
                .id(locatario.getId())
                .razao(locatario.getRazao())
                .fantasia(locatario.getFantasia())
                .cnpj(locatario.getCnpj())
                .ie(locatario.getIe())
                .telefone(locatario.getTelefone())
                .email(locatario.getEmail())
                .endereco(locatario.getEndereco())
                .numero(locatario.getNumero())
                .bairro(locatario.getBairro())
                .complemento(locatario.getComplemento())
                .cep(locatario.getCep())
                .ativo(locatario.getAtivo())
                .cidade(buildToCidadeResponseDTO(locatario.getCidade()))
                .build();
    }

    @Override
    public ResumoLocatarioResponseDTO buildToResumoLocatarioDTO(Locatario locatario) {
        return ResumoLocatarioResponseDTO
                .builder()
                .id(locatario.getId())
                .razao(locatario.getRazao())
                .fantasia(locatario.getFantasia())
                .cnpj(locatario.getCnpj())
                .build();
    }

    @Override
    public ImovelResponseDTO buildToImovelResponseDTO(Imovel imovel) {
        return ImovelResponseDTO
                .builder()
                .id(imovel.getId())
                .matricula(imovel.getMatricula())
                .valor(imovel.getValor())
                .endereco(imovel.getEndereco())
                .numero(imovel.getNumero())
                .bairro(imovel.getBairro())
                .complemento(imovel.getComplemento())
                .cep(imovel.getCep())
                .cidade(buildToCidadeResponseDTO(imovel.getCidade()))
                .proprietario(buildToResumoEmpresaDTO(imovel.getProprietario()))
                .build();
    }

    @Override
    public ResumoImovelResponseDTO buildToResumoImovelDTO(Imovel imovel) {
        return ResumoImovelResponseDTO
                .builder()
                .id(imovel.getId())
                .valor(imovel.getValor())
                .endereco(imovel.getEndereco())
                .numero(imovel.getNumero())
                .complemento(imovel.getComplemento())
                .bairro(imovel.getBairro())
                .build();
    }

    @Override
    public ContratoResponseDTO buildToContratoResponseDTO(Contrato contrato) {
        return ContratoResponseDTO
                .builder()
                .id(contrato.getId())
                .data(contrato.getData())
                .validade(contrato.getValidade())
                .valor(contrato.getValor())
                .imovel(buildToResumoImovelDTO(contrato.getImovel()))
                .locatario(buildToResumoLocatarioDTO(contrato.getLocatario()))
                .build();
    }

    @Override
    public AluguelResponseDTO buildToAluguelResponseDTO(Aluguel aluguel) {
        return AluguelResponseDTO
                .builder()
                .id(aluguel.getId())
                .recibo(aluguel.getRecibo())
                .data(aluguel.getData())
                .valor(aluguel.getValor())
                .iptu(aluguel.getIptu())
                .seguro(aluguel.getSeguro())
                .multa(aluguel.getMulta())
                .outros(aluguel.getOutros())
                .desconto(aluguel.getDesconto())
                .total(aluguel.getTotal())
                .status(aluguel.getStatus().name())
                .contrato(buildToResumoContratoDTO(aluguel.getContrato()))
                .build();
    }

    @Override
    public ResumoContratoResponseDTO buildToResumoContratoDTO(Contrato contrato) {
        return ResumoContratoResponseDTO
                .builder()
                .id(contrato.getId())
                .valor(contrato.getValor())
                .data(contrato.getData())
                .validade(contrato.getValidade())
                .locatario(contrato.getLocatario().getRazao())
                .imovel(contrato.getImovel().getEndereco())
                .build();
    }
}
