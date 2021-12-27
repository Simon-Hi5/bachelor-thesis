package edu.hm.communication.controller;

import edu.hm.communication.CommunicationApplication;
import edu.hm.communication.common.BadRequestException;
import edu.hm.communication.common.ResourceNotFoundException;
import edu.hm.communication.common.SwaggerConfig;
import edu.hm.communication.persistence.Communication;
import edu.hm.communication.service.CommunicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Controller for communication operations.
 *
 * @author Simon Hirner
 */
@RestController
@RequestMapping("/communications")
@Api(tags = {SwaggerConfig.CONTACT_TAG})
public class CommunicationController {

    private static final Logger logger = LoggerFactory.getLogger(CommunicationApplication.class);

    private final CommunicationService communicationService;

    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Communications.")
    List<Communication> getAllCommunications() {
        logger.debug("GET /communications");
        return communicationService.getAllCommunications();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save new Communication.")
    Communication saveCommunication(@RequestBody Communication newCommunication) {
        logger.debug("POST /communications");
        try {
            return communicationService.saveCommunication(newCommunication);
        } catch (ConstraintViolationException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Communication by ID.")
    Communication getCommunication(@PathVariable String id) {
        logger.debug("GET /communications/{}", id);
        return communicationService.getCommunication(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Replace Communication by ID with new Communication.")
    Communication replaceCommunication(@PathVariable String id, @RequestBody Communication newCommunication) {
        logger.debug("PUT /communications/{}", id);
        return communicationService.replaceCommunication(id, newCommunication);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Communication by ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCommunication(@PathVariable String id) {
        logger.debug("DELETE /communications/{}", id);
        communicationService.deleteCommunication(id);
    }

}

