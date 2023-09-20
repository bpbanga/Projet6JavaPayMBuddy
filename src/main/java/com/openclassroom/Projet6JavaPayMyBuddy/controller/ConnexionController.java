/*
 * package com.openclassroom.Projet6JavaPayMyBuddy.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping;
 * 
 * import com.openclassroom.Projet6JavaPayMyBuddy.model.Utilisateur; import
 * com.openclassroom.Projet6JavaPayMyBuddy.repository.UtilisateurRepository;
 * import com.openclassroom.Projet6JavaPayMyBuddy.service.UtilisateurService;
 * 
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpSession;
 * 
 * 
 * 
 * @Controller public class ConnexionController {
 * 
 * @GetMapping("/storeData") public String storeData(HttpServletRequest request)
 * { HttpSession session = request.getSession(); // Store data in the session
 * session.setAttribute("email", "toto");
 * 
 * session.setAttribute("password", "password"); return "data_stored"; }
 * 
 * 
 * @GetMapping("/getData") public String getData(HttpSession session) { String
 * username = (String) session.getAttribute("username"); return "Hello, " +
 * username; }
 * 
 * 
 * @GetMapping("/connexion") public String showConnexion(Model model) {
 * 
 * model.addAttribute("utiList", utilisateurRepository.findAll());
 * model.addAttribute("utilisateur", new Utilisateur());
 * 
 * return "Connexion"; }
 * 
 * @Autowired private UtilisateurRepository utilisateurRepository;
 * 
 * @Autowired private UtilisateurService utilisateurService;
 * 
 * @PostMapping("/transfer") public String postConnexion( @ModelAttribute
 * Utilisateur newUtilisateur) { boolean verif = false;
 * utilisateurRepository.save(newUtilisateur);
 * 
 * List<Utilisateur> utilisateurs = utilisateurService.getUtilisateurs() ; for (
 * Utilisateur utilisateur : utilisateurs) { if( utilisateur.getEmail() ==
 * newUtilisateur.getEmail() && utilisateur.getPassword() ==
 * newUtilisateur.getPassword()) { verif = true;}; }
 * 
 * if( verif == true) {
 * 
 * 
 * return "Home"; }
 * 
 * else return "The authentification is not correct";
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * }
 */