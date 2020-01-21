package br.com.sansyro.sgp.api.recurso;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.ajenterprise.api.util.DataUlil;

@RestController
@RequestMapping("/testeMetodos")
@SuppressWarnings("deprecation")
public class TesteRecurso {
	
	@GetMapping
	public List<String> buscarCursos(){
		List<String> datas = new ArrayList<>();
		datas.add(DataUlil.obterDataHoraAtual());
		datas.add(DataUlil.obterDataAtual());
		datas.add(DataUlil.obterHoraAtual());
		
		return datas;
	}
	
	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody String pData, HttpServletResponse pResponse) {
		Date lData = new Date(pData);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{data}").buildAndExpand(lData).toUri();
		pResponse.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(DataUlil.obterDataFormatada(lData));
	}
	
}
