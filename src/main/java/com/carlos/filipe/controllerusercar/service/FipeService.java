package com.carlos.filipe.controllerusercar.service;

import com.carlos.filipe.controllerusercar.model.Fipe;
import com.carlos.filipe.controllerusercar.model.dto.CarDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipeService", url="https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeService {

    @GetMapping(value = "/marcas")
    public List<Fipe> getBrand();

    @GetMapping(value = "/marcas/{idMarca}/modelos")
    public Fipe getModels(@PathVariable("idMarca") String idBrand);

    @GetMapping(value = "/marcas/{idMarca}/modelos/{idModelo}/anos")
    public List<Fipe> getYears(@PathVariable("idMarca") String idBrand, @PathVariable("idModelo") String idModel);

    @GetMapping(value = "/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
    public CarDTO getCars(@PathVariable("idMarca") String idMarca, @PathVariable("idModelo") String idModel, @PathVariable("idAno") String idYear);
}
