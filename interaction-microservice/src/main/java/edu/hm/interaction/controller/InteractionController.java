package edu.hm.interaction.controller;

import edu.hm.interaction.InteractionApplication;
import edu.hm.interaction.common.BadRequestException;
import edu.hm.interaction.common.ResourceNotFoundException;
import edu.hm.interaction.common.SwaggerConfig;
import edu.hm.interaction.persistence.Interaction;
import edu.hm.interaction.service.InteractionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Controller for interaction operations.
 *
 * @author Simon Hirner
 */
@RestController
@RequestMapping("/interactions")
@Api(tags = {SwaggerConfig.CONTACT_TAG})
public class InteractionController {

    private static final Logger logger = LoggerFactory.getLogger(InteractionApplication.class);

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Interactions.")
    List<Interaction> getAllInteractions() {
        logger.debug("GET /interactions");
        return interactionService.getAllInteractions();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save new Interaction.")
    Interaction saveInteraction(@RequestBody Interaction newInteraction) {
        logger.debug("POST /interactions");
        try {
            return interactionService.saveInteraction(newInteraction);
        } catch (ConstraintViolationException exception) {
            throw new BadRequestException(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Interaction by ID.")
    Interaction getInteraction(@PathVariable String id) {
        logger.debug("GET /interactions/{}", id);
        return interactionService.getInteraction(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Replace Interaction by ID with new Interaction.")
    Interaction replaceInteraction(@PathVariable String id, @RequestBody Interaction newInteraction) {
        logger.debug("PUT /interactions/{}", id);
        return interactionService.replaceInteraction(id, newInteraction);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Interaction by ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteInteraction(@PathVariable String id) {
        logger.debug("DELETE /interactions/{}", id);
        interactionService.deleteInteraction(id);
    }

}

