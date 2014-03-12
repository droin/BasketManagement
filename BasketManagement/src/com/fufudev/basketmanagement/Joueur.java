package com.fufudev.basketmanagement;

public class Joueur {

	private int numero;
	private String nom;
	private int i_points;
	private int i_tir2_marque;
	private int i_tir2_tente;
	private int i_tir3_marque;
	private int i_tir3_tente;
	private int i_passdec;
	private int i_lf_tente;
	private int i_lf_marque;
	private int i_reboff;
	private int i_rebdef;
	private int i_balperd;
	private int i_interc;
	private int i_contr;
	private int i_fautprov;
	private int i_fautpers;
	private int i_eval;
	
	Joueur(int _numero, String _nom) {
		this.numero = _numero; 
		this.nom = _nom;
		i_points = 0;
		i_tir2_marque = 0;
		i_tir2_tente = 0;
		i_tir3_marque = 0;
		i_tir3_tente = 0;
		i_passdec = 0;
		i_lf_tente = 0;
		i_lf_marque = 0;
		i_reboff = 0;
		i_rebdef = 0;
		i_balperd = 0;
		i_interc = 0;
		i_contr = 0;
		i_fautprov = 0;
		i_fautpers = 0;
		i_eval = 0;
	}
	
	public int calculPoints() {
		return this.i_tir3_marque *3 + this.i_tir2_marque *2 + this.i_lf_marque; 
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getI_points() {
		return i_points;
	}
	public void setI_points(int i_points) {
		this.i_points = i_points;
	}

	public int getI_tir2_marque() {
		return i_tir2_marque;
	}
	public void setI_tir2_marque(int i_tir2_marque) {
		this.i_tir2_marque = i_tir2_marque;
	}

	public int getI_tir2_tente() {
		return i_tir2_tente;
	}
	public void setI_tir2_tente(int i_tir2_tente) {
		this.i_tir2_tente = i_tir2_tente;
	}

	public int getI_tir3_marque() {
		return i_tir3_marque;
	}
	public void setI_tir3_marque(int i_tir3_marque) {
		this.i_tir3_marque = i_tir3_marque;
	}

	public int getI_tir3_tente() {
		return i_tir3_tente;
	}
	public void setI_tir3_tente(int i_tir3_tente) {
		this.i_tir3_tente = i_tir3_tente;
	}

	public int getI_passdec() {
		return i_passdec;
	}
	public void setI_passdec(int i_passdec) {
		this.i_passdec = i_passdec;
	}

	public int getI_lf_tente() {
		return i_lf_tente;
	}
	public void setI_lf_tente(int i_lf_tente) {
		this.i_lf_tente = i_lf_tente;
	}

	public int getI_lf_marque() {
		return i_lf_marque;
	}
	public void setI_lf_marque(int i_lf_marque) {
		this.i_lf_marque = i_lf_marque;
	}

	public int getI_reboff() {
		return i_reboff;
	}
	public void setI_reboff(int i_reboff) {
		this.i_reboff = i_reboff;
	}

	public int getI_rebdef() {
		return i_rebdef;
	}
	public void setI_rebdef(int i_rebdef) {
		this.i_rebdef = i_rebdef;
	}

	public int getI_balperd() {
		return i_balperd;
	}
	public void setI_balperd(int i_balperd) {
		this.i_balperd = i_balperd;
	}

	public int getI_interc() {
		return i_interc;
	}
	public void setI_interc(int i_interc) {
		this.i_interc = i_interc;
	}

	public int getI_contr() {
		return i_contr;
	}
	public void setI_contr(int i_contr) {
		this.i_contr = i_contr;
	}

	public int getI_fautprov() {
		return i_fautprov;
	}
	public void setI_fautprov(int i_fautprov) {
		this.i_fautprov = i_fautprov;
	}

	public int getI_fautpers() {
		return i_fautpers;
	}
	public void setI_fautpers(int i_fautpers) {
		this.i_fautpers = i_fautpers;
	}

	public int getI_eval() {
		return i_eval;
	}
	public void setI_eval(int i_eval) {
		this.i_eval = i_eval;
	}
	
	
}
