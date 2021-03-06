/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Fournisseur;
import controller.util.PdfUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author User
 */
@Stateless
public class FournisseurFacade extends AbstractFacade<Fournisseur> {

    @PersistenceContext(unitName = "gmaov3PU")
    private EntityManager em;
    
    @Override
    public void create(Fournisseur fournisseur) {
        fournisseur.setId(generateId("Fournisseur", "id"));
        super.create(fournisseur);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public void generatePdf() throws JRException, IOException{
        Map<String,Object> params = new HashMap();
        params.put("responsable", "Mme HAGCHI Faiza");
        PdfUtil.generatePdf(findAll(), params, "fournisseur", "/jasper/fournisseur.jasper");
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }
    
}
