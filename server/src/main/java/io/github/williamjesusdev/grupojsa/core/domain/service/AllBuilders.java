package io.github.williamjesusdev.grupojsa.core.domain.service;

import io.github.williamjesusdev.grupojsa.core.domain.entity.Cidade;
import io.github.williamjesusdev.grupojsa.core.domain.entity.Estado;
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

public interface AllBuilders {
    EstadoResponseDTO buildToEstadoResponseDTO(Estado estado);

    CidadeResponseDTO buildToCidadeResponseDTO(Cidade cidade);

    EmpresaResponseDTO buildToEmpresaResponseDTO(Empresa empresa);

    ResumoEmpresaResponseDTO buildToResumoEmpresaDTO(Empresa empresa);

    LocatarioResponseDTO buildToLocatarioResponseDTO(Locatario locatario);

    ResumoLocatarioResponseDTO buildToResumoLocatarioDTO(Locatario locatario);

    ImovelResponseDTO buildToImovelResponseDTO(Imovel imovel);

    ResumoImovelResponseDTO buildToResumoImovelDTO(Imovel imovel);

    ContratoResponseDTO buildToContratoResponseDTO(Contrato contrato);

    AluguelResponseDTO buildToAluguelResponseDTO(Aluguel aluguel);

    ResumoContratoResponseDTO buildToResumoContratoDTO(Contrato contrato);
}
