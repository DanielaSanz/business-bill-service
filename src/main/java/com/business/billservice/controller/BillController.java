package com.business.billservice.controller;

import com.business.billservice.controller.http.BillResponse;
import com.business.billservice.controller.http.GenericResponse;
import com.business.billservice.validator.Validator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

@RestController
public class BillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);
    private final Validator<Integer> validateIdNumber;
    private final Function<Integer, BillResponse> billSupplier;

    @Autowired
    public BillController(Validator<Integer> validateIdNumber, Function<Integer, BillResponse> billSupplier) {
        this.validateIdNumber = validateIdNumber;
        this.billSupplier = billSupplier;
    }

    @GetMapping(
            value = "bill/billDetail/{idBill}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Obtener detalles de factura")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se obtienen el detalle de factura", response = BillController.class),
            @ApiResponse(code = 400, message = "Parametros inválido", response = BillController.class),
            @ApiResponse(code = 500, message = "Error inesperado del servicio web", response = BillController.class)
    })
    public ResponseEntity<GenericResponse> obtainBill (@PathVariable Integer idBill){
        try{
            validateIdNumber.validate(idBill);
            return ResponseEntity.ok(billSupplier.apply(idBill));
        }catch (IllegalArgumentException iae){
            LOGGER.warn("El id ingresado no es válido: {}", idBill, iae.getMessage());
            return ResponseEntity.badRequest().body(new GenericResponse(iae.getMessage()));
        } catch (Exception ex){
            LOGGER.error("Ocurrio un error al tratar de obtener el detalle de factura id = {}", idBill);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GenericResponse(ex.getMessage()));
        }
    }
}
