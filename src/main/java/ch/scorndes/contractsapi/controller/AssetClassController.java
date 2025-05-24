package ch.scorndes.contractsapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset-classes")
public class AssetClassController {

    @GetMapping
    public String getAllAssetClasses() {
        // TODO: Renvoyer la liste des classes d’actifs
        return "List of asset classes";
    }
}