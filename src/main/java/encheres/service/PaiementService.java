/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encheres.service;

import encheres.entity.Article;

/**
 *
 * @author admin
 */
public interface PaiementService {
    
    public void payer(Article article);
    
}
