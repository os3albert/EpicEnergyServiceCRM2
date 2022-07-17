package com.energy.crm.clienti.indirizzi.comuni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.energy.crm.messages.Messages;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:comune.properties")
@RestController
@RequestMapping("/comune")
@Slf4j
public class ComuneController {

	@Autowired
	private Environment env;

	@Autowired
	private ComuneService comuneService;

	/**
	 * @param id 's element to get
	 * @return the Object required
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ComuneDTO> getComune(@PathVariable Long id) {

		return ResponseEntity.ok(comuneService.find(id));

	}

	@GetMapping
	public ResponseEntity<List<ComuneImp>> getAll() {

		return ResponseEntity.ok(comuneService.findAll());

	}

	/**
	 * @param comuneDTO body
	 * @return info message
	 */
	@PostMapping
	public ResponseEntity<?> insertComune(@RequestBody ComuneDTO comuneDTO) {

		log.info("SONO DENTRO IL CONTROLLER --- " + comuneDTO.toString());
		comuneService.insert(comuneDTO);

		// return ResponseEntity.ok(env.getProperty("comune.insert.success") + " id
		// inserimento: " + comuneService.insert(comuneDTO)); //$NON-NLS-1$
		return ResponseEntity.ok(env.getProperty("comune.insert.success")); //$NON-NLS-1$

	}

	/**
	 * @param comuneDTO body
	 * @param id        's element to update
	 * @return info messagge update success
	 */
	@PutMapping("{id}")
	public ResponseEntity<String> updateComune(@RequestBody ComuneDTO comuneDTO, @PathVariable Long id) {

		comuneService.update(comuneDTO, id);

		return ResponseEntity.ok(env.getProperty("comune.update.success")); //$NON-NLS-1$
	}

	/**
	 * @param id 's element to delete
	 * @return info message of success or fail
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComune(@PathVariable Long id) {

		comuneService.delete(id);

		return ResponseEntity.ok(env.getProperty("comune.delete.success"));
	}

}
