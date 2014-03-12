package com.fufudev.basketmanagement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueur3;
	private Joueur joueur4;
	private Joueur joueur5;
	private Joueur joueur6;
	private Joueur joueur7;
	private Joueur joueur8;
	private Joueur joueur9;
	private Joueur joueur10;
	private ToggleButton btn_joueur1;
	private ToggleButton btn_joueur2;
	private ToggleButton btn_joueur3;
	private ToggleButton btn_joueur4;
	private ToggleButton btn_joueur5;
	private ToggleButton btn_joueur6;
	private ToggleButton btn_joueur7;
	private ToggleButton btn_joueur8;
	private ToggleButton btn_joueur9;
	private ToggleButton btn_joueur10;
	private ToggleButton btn_tir2marque;// i_btn_actions_checked = 1
	private ToggleButton btn_tir2tente;	// i_btn_actions_checked = 2
	private ToggleButton btn_tir3marque;// i_btn_actions_checked = 3
	private ToggleButton btn_tir3tente;	// i_btn_actions_checked = 4
	private ToggleButton btn_passdec;	// i_btn_actions_checked = 5
	private ToggleButton btn_lfmarque;	// i_btn_actions_checked = 6
	private ToggleButton btn_lftente;	// i_btn_actions_checked = 7
	private ToggleButton btn_reboff;	// i_btn_actions_checked = 8
	private ToggleButton btn_rebdef;	// i_btn_actions_checked = 9
	private ToggleButton btn_balperd;	// i_btn_actions_checked = 10
	private ToggleButton btn_interc;	// i_btn_actions_checked = 11
	private ToggleButton btn_contr;		// i_btn_actions_checked = 12
	private ToggleButton btn_fautprov;	// i_btn_actions_checked = 13
	private ToggleButton btn_fautpers;	// i_btn_actions_checked = 14
//	private ToggleButton btn_minentr;	// i_btn_actions_checked = 15
//	private ToggleButton btn_minsort;	// i_btn_actions_checked = 16
	private TextView tv_joueur_num_nom;
	private TextView tv_joueur_num_points;
	private TextView tv_joueur_num_tir2;
	private TextView tv_joueur_num_tir3;
	private TextView tv_joueur_num_lancerfranc;
	private TextView tv_joueur_num_passdec;
	private TextView tv_joueur_num_rebond;
	private TextView tv_joueur_num_interc;
	private TextView tv_joueur_num_contr;
	private TextView tv_joueur_num_balperd;
	private TextView tv_joueur_num_fautes;
	private TextView tv_joueur_num_eval;
	
	private int nb_joueurs = 0;
	private int i_btn_joueur_checked = 0;
	private int i_btn_actions_checked = 0;
	private int lastJoueur = 0;
	private int lastAction = 0;
	private boolean lastUndoOnce = false; // true si annule une fois ; false si pas annule 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prise_stats_layout);
        
        setupUI();
        
//        setupJoueurs();
        // petite modif
        
    }
    
    private boolean actionTir2Marque(Joueur joueur, boolean back) {
    	if (!back) {
	    	joueur.setI_tir2_marque(joueur.getI_tir2_marque()+1);
	    	joueur.setI_tir2_tente(joueur.getI_tir2_tente()+1);
    	}
    	else {
    		joueur.setI_tir2_marque(joueur.getI_tir2_marque()-1);
	    	joueur.setI_tir2_tente(joueur.getI_tir2_tente()-1);
    	}
    	int tirs_marques_total = joueur.getI_tir2_marque()+joueur.getI_tir3_marque();
    	int tirs_tentes_total = joueur.getI_tir2_tente()+joueur.getI_tir3_tente();
    	tv_joueur_num_tir2.setText(tirs_marques_total+" / "+tirs_tentes_total);
    	tv_joueur_num_points.setText(""+joueur.calculPoints());
    	return true;
    }
    private boolean actionTir2Tente(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_tir2_tente(joueur.getI_tir2_tente()+1);
    	}
    	else {    		
    		joueur.setI_tir2_tente(joueur.getI_tir2_tente()-1);
    	}
    	int tirs_marques_total = joueur.getI_tir2_marque()+joueur.getI_tir3_marque();
    	int tirs_tentes_total = joueur.getI_tir2_tente()+joueur.getI_tir3_tente();
    	tv_joueur_num_tir2.setText(tirs_marques_total+" / "+tirs_tentes_total);
    	return true;
    }
    private boolean actionTir3Marque(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_tir3_marque(joueur.getI_tir3_marque()+1);
    		joueur.setI_tir3_tente(joueur.getI_tir3_tente()+1);
    	}
    	else {
    		joueur.setI_tir3_marque(joueur.getI_tir3_marque()-1);
    		joueur.setI_tir3_tente(joueur.getI_tir3_tente()-1);    		
    	}
    	int tirs_marques_total = joueur.getI_tir2_marque()+joueur.getI_tir3_marque();
    	int tirs_tentes_total = joueur.getI_tir2_tente()+joueur.getI_tir3_tente();
    	tv_joueur_num_tir2.setText(tirs_marques_total+" / "+tirs_tentes_total);
    	tv_joueur_num_tir3.setText(joueur.getI_tir3_marque()+" / "+joueur.getI_tir3_tente());
    	tv_joueur_num_points.setText(""+joueur.calculPoints());
    	return true;
    }
    private boolean actionTir3Tente(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_tir3_tente(joueur.getI_tir3_tente()+1);
    	}
    	else {
    		joueur.setI_tir3_tente(joueur.getI_tir3_tente()-1);
    	}
    	int tirs_marques_total = joueur.getI_tir2_marque()+joueur.getI_tir3_marque();
    	int tirs_tentes_total = joueur.getI_tir2_tente()+joueur.getI_tir3_tente();
    	tv_joueur_num_tir2.setText(tirs_marques_total+" / "+tirs_tentes_total);
    	tv_joueur_num_tir3.setText(joueur.getI_tir3_marque()+" / "+joueur.getI_tir3_tente());
    	return true;
    }
    private boolean actionPassDec(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_passdec(joueur.getI_passdec()+1);
    	}
    	else {    		
    		joueur.setI_passdec(joueur.getI_passdec()-1);
    	}
    	tv_joueur_num_passdec.setText(""+joueur.getI_passdec());
    	return true;
    }
    private boolean actionLfMarque(Joueur joueur, boolean back) {
    	if (!back) {
	    	joueur.setI_lf_marque(joueur.getI_lf_marque()+1);
	    	joueur.setI_lf_tente(joueur.getI_lf_tente()+1);
    	}
    	else {
	    	joueur.setI_lf_marque(joueur.getI_lf_marque()-1);
	    	joueur.setI_lf_tente(joueur.getI_lf_tente()-1);
    	}
    	tv_joueur_num_lancerfranc.setText(joueur.getI_lf_marque()+" / "+joueur.getI_lf_tente());
    	tv_joueur_num_points.setText(""+joueur.calculPoints());
    	return true;
    }
    private boolean actionLfTente(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_lf_tente(joueur.getI_lf_tente()+1);
    	}
    	else {
    		joueur.setI_lf_tente(joueur.getI_lf_tente()-1);
    	}
    	tv_joueur_num_lancerfranc.setText(joueur.getI_lf_marque()+" / "+joueur.getI_lf_tente());
    	return true;
    }
    private boolean actionRebOff(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_reboff(joueur.getI_reboff()+1);
    	}
    	else {
    		joueur.setI_reboff(joueur.getI_reboff()-1);
    	}
    	int rebonds_total = joueur.getI_rebdef()+joueur.getI_reboff();
    	tv_joueur_num_rebond.setText(rebonds_total+" ("+joueur.getI_reboff()+")");
    	return true;
    }
    private boolean actionRebDef(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_rebdef(joueur.getI_rebdef()+1);
    	}
    	else {
    		joueur.setI_rebdef(joueur.getI_rebdef()-1);
    	}
    	int rebonds_total = joueur.getI_rebdef()+joueur.getI_reboff();
    	tv_joueur_num_rebond.setText(rebonds_total+" ("+joueur.getI_reboff()+")");
    	return true;
    }
    private boolean actionBalPerd(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_balperd(joueur.getI_balperd()+1);
    	}
    	else {
    		joueur.setI_balperd(joueur.getI_balperd()-1);
    	}
    	tv_joueur_num_balperd.setText(""+joueur.getI_balperd());
    	return true;
    }
    private boolean actionInterc(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_interc(joueur.getI_interc()+1);
    	}
    	else {
    		joueur.setI_interc(joueur.getI_interc()-1);
    	}
    	tv_joueur_num_interc.setText(""+joueur.getI_interc());
    	return true;
    }
    private boolean actionContr(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_contr(joueur.getI_contr()+1);
    	}
    	else {
    		joueur.setI_contr(joueur.getI_contr()-1);
    	}
    	tv_joueur_num_contr.setText(""+joueur.getI_contr());
    	return true;
    }
    private boolean actionFautProv(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_fautprov(joueur.getI_fautprov()+1);
    	}
    	else {
    		joueur.setI_fautprov(joueur.getI_fautprov()-1);
    	}
    	tv_joueur_num_fautes.setText(joueur.getI_fautprov()+" / "+joueur.getI_fautpers());
    	return true;
    }
    private boolean actionFautPers(Joueur joueur, boolean back) {
    	if (!back) {
    		joueur.setI_fautpers(joueur.getI_fautpers()+1);
    	}
    	else {
    		joueur.setI_fautpers(joueur.getI_fautpers()-1);
    	}
    	tv_joueur_num_fautes.setText(joueur.getI_fautprov()+" / "+joueur.getI_fautpers());
    	return true;
    }
    // TODO private boolean actionEval(Joueur joueur) {}
    
    private void undoLastAction() {
    	if (lastUndoOnce == false) {
    		useClicks(lastJoueur, lastAction, true);
    		lastUndoOnce = true;
    		switch (lastJoueur) {
        	case 1:
        		retablirDonnees(joueur1);
        		break;
        	case 2:
        		retablirDonnees(joueur2);
        		break;
        	case 3:
        		retablirDonnees(joueur3);
        		break;
        	case 4:
        		retablirDonnees(joueur4);
        		break;
        	case 5:
        		retablirDonnees(joueur5);
        		break;
        	case 6:
        		retablirDonnees(joueur6);
        		break;
        	case 7:
        		retablirDonnees(joueur7);
        		break;
        	case 8:
        		retablirDonnees(joueur8);
        		break;
        	case 9:
        		retablirDonnees(joueur9);
        		break;
        	case 10:
        		retablirDonnees(joueur10);
        		break;
        	}
    		resetBtnJoueur(true);
    		resetBtnActions(true);
    	}
    }
    
    private void backLastAction(int i_joueur, int action) {
    	lastJoueur = i_joueur;
    	lastAction = action;
    	lastUndoOnce = false;
    }
    
    private void useClicks(int i_joueur, int action, boolean backAction) {
    	Joueur joueur = new Joueur(0,"");
    	switch (i_joueur) {
    	case 1:
    		joueur = joueur1;
    		break;
    	case 2:
    		joueur = joueur2;
    		break;
    	case 3:
    		joueur = joueur3;
    		break;
    	case 4:
    		joueur = joueur4;
    		break;
    	case 5:
    		joueur = joueur5;
    		break;
    	case 6:
    		joueur = joueur6;
    		break;
    	case 7:
    		joueur = joueur7;
    		break;
    	case 8:
    		joueur = joueur8;
    		break;
    	case 9:
    		joueur = joueur9;
    		break;
    	case 10:
    		joueur = joueur10;
    		break;
    	}
    	switch (action) {
		case 1:
			if (actionTir2Marque(joueur, backAction))
				backLastAction(i_joueur, 1);
			break;
		case 2:
			if (actionTir2Tente(joueur, backAction))
				backLastAction(i_joueur, 2);
			break;
		case 3:
			if (actionTir3Marque(joueur, backAction))
				backLastAction(i_joueur, 3);
			break;
		case 4:
			if (actionTir3Tente(joueur, backAction))
				backLastAction(i_joueur, 4);
			break;
		case 5:
			if (actionPassDec(joueur, backAction))
				backLastAction(i_joueur, 5);
			break;
		case 6:
			if (actionLfMarque(joueur, backAction))
				backLastAction(i_joueur, 6);
			break;
		case 7:
			if (actionLfTente(joueur, backAction))
				backLastAction(i_joueur, 7);
			break;
		case 8:
			if (actionRebOff(joueur, backAction))
				backLastAction(i_joueur, 8);
			break;
		case 9:
			if (actionRebDef(joueur, backAction))
				backLastAction(i_joueur, 9);
			break;
		case 10:
			if (actionBalPerd(joueur, backAction))
				backLastAction(i_joueur, 10);
			break;
		case 11:
			if (actionInterc(joueur, backAction))
				backLastAction(i_joueur, 11);
			break;
		case 12:
			if (actionContr(joueur, backAction))
				backLastAction(i_joueur, 12);
			break;
		case 13:
			if (actionFautProv(joueur, backAction))
				backLastAction(i_joueur, 13);
			break;
		case 14:
			if (actionFautPers(joueur, backAction))
				backLastAction(i_joueur, 14);
			break;
		default:
			break;
		}
    }
    
    
    private void resetBtnJoueur(boolean avecLIndex) {
    	if (avecLIndex)
    		i_btn_joueur_checked = 0;
		btn_joueur1.setChecked(false);
		btn_joueur2.setChecked(false);
		btn_joueur3.setChecked(false);
		btn_joueur4.setChecked(false);
		btn_joueur5.setChecked(false);
		btn_joueur6.setChecked(false);
		btn_joueur7.setChecked(false);
		btn_joueur8.setChecked(false);
		btn_joueur9.setChecked(false);
		btn_joueur10.setChecked(false);
	}
    
    private void resetBtnActions(boolean avecLIndex) {
    	if (avecLIndex)
    		i_btn_actions_checked = 0;
    	btn_tir2marque.setChecked(false);
    	btn_tir2tente.setChecked(false);
    	btn_tir3marque.setChecked(false);
    	btn_tir3tente.setChecked(false);
    	btn_lfmarque.setChecked(false);
    	btn_lftente.setChecked(false);
    	btn_passdec.setChecked(false);
    	btn_reboff.setChecked(false);
    	btn_rebdef.setChecked(false);
    	btn_interc.setChecked(false);
    	btn_contr.setChecked(false);
    	btn_balperd.setChecked(false);
    	btn_fautprov.setChecked(false);
    	btn_fautpers.setChecked(false);
//    	btn_minentr.setChecked(false);
//    	btn_minsort.setChecked(false);
    }
    
    private void retablirDonnees(Joueur joueur) {
    	tv_joueur_num_nom.setText(joueur.getNumero()+" - "+joueur.getNom());
    	tv_joueur_num_points.setText(""+joueur.calculPoints());
    	int tirs_marques_total = joueur.getI_tir2_marque()+joueur.getI_tir3_marque();
    	int tirs_tentes_total = joueur.getI_tir2_tente()+joueur.getI_tir3_tente();
    	tv_joueur_num_tir2.setText(tirs_marques_total+" / "+tirs_tentes_total);
    	tv_joueur_num_tir3.setText(joueur.getI_tir3_marque()+" / "+joueur.getI_tir3_tente());
    	tv_joueur_num_lancerfranc.setText(joueur.getI_lf_marque()+" / "+joueur.getI_lf_tente());
    	tv_joueur_num_passdec.setText(""+joueur.getI_passdec());
    	int rebonds_total = joueur.getI_rebdef()+joueur.getI_reboff();
    	tv_joueur_num_rebond.setText(rebonds_total+" ("+joueur.getI_reboff()+")");
    	tv_joueur_num_interc.setText(""+joueur.getI_interc());
    	tv_joueur_num_contr.setText(""+joueur.getI_contr());
    	tv_joueur_num_balperd.setText(""+joueur.getI_balperd());
    	tv_joueur_num_fautes.setText(joueur.getI_fautprov()+" / "+joueur.getI_fautpers());
    	// TODO calculer l'evaluation
    	tv_joueur_num_eval.setText(""+joueur.getI_eval());
    }
    
    public void onClickJoueur(View view) {
		resetBtnJoueur(false);
		
    	switch (view.getId()) {
		case R.id.btn_joueur1:
			if (i_btn_joueur_checked == 1) {
				btn_joueur1.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur1);
				if (i_btn_actions_checked == 0) {
					btn_joueur1.setChecked(true);
					i_btn_joueur_checked = 1;
				}
				else {
					useClicks(1, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur2:
			if (i_btn_joueur_checked == 2) {
				btn_joueur2.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur2);
				if (i_btn_actions_checked == 0) {
					btn_joueur2.setChecked(true);
					i_btn_joueur_checked = 2;
				}
				else {
					useClicks(2, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur3:
			if (i_btn_joueur_checked == 3) {
				btn_joueur3.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur3);
				if (i_btn_actions_checked == 0) {
					btn_joueur3.setChecked(true);
					i_btn_joueur_checked = 3;
				}
				else {
					useClicks(3, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur4:
			if (i_btn_joueur_checked == 4) {
				btn_joueur4.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur4);
				if (i_btn_actions_checked == 0) {
					btn_joueur4.setChecked(true);
					i_btn_joueur_checked = 4;
				}
				else {
					useClicks(4, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur5:
			if (i_btn_joueur_checked == 5) {
				btn_joueur5.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur5);
				if (i_btn_actions_checked == 0) {
					btn_joueur5.setChecked(true);
					i_btn_joueur_checked = 5;
				}
				else {
					useClicks(5, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur6:
			if (i_btn_joueur_checked == 6) {
				btn_joueur6.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur6);
				if (i_btn_actions_checked == 0) {
					btn_joueur6.setChecked(true);
					i_btn_joueur_checked = 6;
				}
				else {
					useClicks(6, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur7:
			if (i_btn_joueur_checked == 7) {
				btn_joueur7.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur7);
				if (i_btn_actions_checked == 0) {
					btn_joueur7.setChecked(true);
					i_btn_joueur_checked = 7;
				}
				else {
					useClicks(7, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur8:
			if (i_btn_joueur_checked == 8) {
				btn_joueur8.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur8);
				if (i_btn_actions_checked == 0) {
					btn_joueur8.setChecked(true);
					i_btn_joueur_checked = 8;
				}
				else {
					useClicks(8, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur9:
			if (i_btn_joueur_checked == 9) {
				btn_joueur9.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur9);
				if (i_btn_actions_checked == 0) {
					btn_joueur9.setChecked(true);
					i_btn_joueur_checked = 9;
				}
				else {
					useClicks(9, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_joueur10:
			if (i_btn_joueur_checked == 10) {
				btn_joueur10.setChecked(false);
				i_btn_joueur_checked = 0;
			}
			else {
				retablirDonnees(joueur10);
				if (i_btn_actions_checked == 0) {
					btn_joueur10.setChecked(true);
					i_btn_joueur_checked = 10;
				}
				else {
					useClicks(10, i_btn_actions_checked, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		}
    }

	public void onClickActions(View view) {
		resetBtnActions(false);
		
		switch (view.getId()) {
		case R.id.btn_tir2marque:
			if (i_btn_actions_checked == 1) {
				btn_tir2marque.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_tir2marque.setChecked(true);
					i_btn_actions_checked = 1;
				}
				else {
					useClicks(i_btn_joueur_checked, 1, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_tir2tente:
			if (i_btn_actions_checked == 2) {
				btn_tir2tente.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_tir2tente.setChecked(true);
					i_btn_actions_checked = 2;
				}
				else {
					useClicks(i_btn_joueur_checked, 2, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_tir3marque:
			if (i_btn_actions_checked == 3) {
				btn_tir3marque.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_tir3marque.setChecked(true);
					i_btn_actions_checked = 3;
				}
				else {
					useClicks(i_btn_joueur_checked, 3, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_tir3tente:
			if (i_btn_actions_checked == 4) {
				btn_tir3tente.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_tir3tente.setChecked(true);
					i_btn_actions_checked = 4;
				}
				else {
					useClicks(i_btn_joueur_checked, 4, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;	
		case R.id.btn_passdec:
			if (i_btn_actions_checked == 5) {
				btn_passdec.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_passdec.setChecked(true);
					i_btn_actions_checked = 5;
				}
				else {
					useClicks(i_btn_joueur_checked, 5, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_lfmarque:
			if (i_btn_actions_checked == 6) {
				btn_lfmarque.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_lfmarque.setChecked(true);
					i_btn_actions_checked = 6;
				}
				else {
					useClicks(i_btn_joueur_checked, 6, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;	
		case R.id.btn_lftente:
			if (i_btn_actions_checked == 7) {
				btn_lftente.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_lftente.setChecked(true);
					i_btn_actions_checked = 7;
				}
				else {
					useClicks(i_btn_joueur_checked, 7, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_reboff:
			if (i_btn_actions_checked == 8) {
				btn_reboff.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_reboff.setChecked(true);
					i_btn_actions_checked = 8;
				}
				else {
					useClicks(i_btn_joueur_checked, 8, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;	
		case R.id.btn_rebdef:
			if (i_btn_actions_checked == 9) {
				btn_rebdef.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_rebdef.setChecked(true);
					i_btn_actions_checked = 9;
				}
				else {
					useClicks(i_btn_joueur_checked, 9, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_balperd:
			if (i_btn_actions_checked == 10) {
				btn_balperd.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_balperd.setChecked(true);
					i_btn_actions_checked = 10;
				}
				else {
					useClicks(i_btn_joueur_checked, 10, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_interc:
			if (i_btn_actions_checked == 11) {
				btn_interc.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_interc.setChecked(true);
					i_btn_actions_checked = 11;
				}
				else {
					useClicks(i_btn_joueur_checked, 11, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;	
		case R.id.btn_contr:
			if (i_btn_actions_checked == 12) {
				btn_contr.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_contr.setChecked(true);
					i_btn_actions_checked = 12;
				}
				else {
					useClicks(i_btn_joueur_checked, 12, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_fautprov:
			if (i_btn_actions_checked == 13) {
				btn_fautprov.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_fautprov.setChecked(true);
					i_btn_actions_checked = 13;
				}
				else {
					useClicks(i_btn_joueur_checked, 13, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
		case R.id.btn_fautpers:
			if (i_btn_actions_checked == 14) {
				btn_fautpers.setChecked(false);
				i_btn_actions_checked = 0;
			}
			else {
				if (i_btn_joueur_checked == 0) {
					btn_fautpers.setChecked(true);
					i_btn_actions_checked = 14;
				}
				else {
					useClicks(i_btn_joueur_checked, 14, false);
					resetBtnJoueur(true);
					resetBtnActions(true);
				}
			}
			return;
//		case R.id.btn_minentr:
//			if (i_btn_actions_checked == 14) {
//				btn_minentr.setChecked(false);
//				i_btn_actions_checked = 0;
//			}
//			else {
//				if (i_btn_joueur_checked == 0) {
//					btn_minentr.setChecked(true);
//					i_btn_actions_checked = 14;
//				}
//				else {
//					useClicks(i_btn_joueur_checked, 1);
//					resetBtnJoueur(true);
//					resetBtnActions(true);
//				}
//			}
//			return;
//		case R.id.btn_minsort:
//			if (i_btn_actions_checked == 15) {
//				btn_minsort.setChecked(false);
//				i_btn_actions_checked = 0;
//			}
//			else {
//				if (i_btn_joueur_checked == 0) {
//					btn_minsort.setChecked(true);
//					i_btn_actions_checked = 15;
//				}
//				else {
//					useClicks(i_btn_joueur_checked, 1);
//					resetBtnJoueur(true);
//					resetBtnActions(true);
//				}
//			}
//			return;
		}
		
	}

	
	private void setupUI() {
		btn_joueur1 = (ToggleButton) this.findViewById(R.id.btn_joueur1);
		btn_joueur2 = (ToggleButton) this.findViewById(R.id.btn_joueur2);
		btn_joueur3 = (ToggleButton) this.findViewById(R.id.btn_joueur3);
		btn_joueur4 = (ToggleButton) this.findViewById(R.id.btn_joueur4);
		btn_joueur5 = (ToggleButton) this.findViewById(R.id.btn_joueur5);
		btn_joueur6 = (ToggleButton) this.findViewById(R.id.btn_joueur6);
		btn_joueur7 = (ToggleButton) this.findViewById(R.id.btn_joueur7);
		btn_joueur8 = (ToggleButton) this.findViewById(R.id.btn_joueur8);
		btn_joueur9 = (ToggleButton) this.findViewById(R.id.btn_joueur9);
		btn_joueur10 = (ToggleButton) this.findViewById(R.id.btn_joueur10);
		
		btn_tir2marque = (ToggleButton) this.findViewById(R.id.btn_tir2marque);
		btn_tir2tente = (ToggleButton) this.findViewById(R.id.btn_tir2tente);
		btn_tir3marque = (ToggleButton) this.findViewById(R.id.btn_tir3marque);
		btn_tir3tente = (ToggleButton) this.findViewById(R.id.btn_tir3tente);
		btn_lfmarque = (ToggleButton) this.findViewById(R.id.btn_lfmarque);
		btn_lftente = (ToggleButton) this.findViewById(R.id.btn_lftente);
		btn_passdec = (ToggleButton) this.findViewById(R.id.btn_passdec);
		btn_reboff = (ToggleButton) this.findViewById(R.id.btn_reboff);
		btn_rebdef = (ToggleButton) this.findViewById(R.id.btn_rebdef);
		btn_interc = (ToggleButton) this.findViewById(R.id.btn_interc);
		btn_contr = (ToggleButton) this.findViewById(R.id.btn_contr);
		btn_balperd = (ToggleButton) this.findViewById(R.id.btn_balperd);
		btn_fautprov = (ToggleButton) this.findViewById(R.id.btn_fautprov);
		btn_fautpers = (ToggleButton) this.findViewById(R.id.btn_fautpers);
//		btn_minentr = (ToggleButton) this.findViewById(R.id.btn_minentr);
//		btn_minsort = (ToggleButton) this.findViewById(R.id.btn_minsort);
		
		tv_joueur_num_nom = (TextView) this.findViewById(R.id.tv_joueur_num_nom);
		tv_joueur_num_points = (TextView) this.findViewById(R.id.tv_joueur_num_points);
		tv_joueur_num_tir2 = (TextView) this.findViewById(R.id.tv_joueur_num_tir2);
		tv_joueur_num_tir3 = (TextView) this.findViewById(R.id.tv_joueur_num_tir3);
		tv_joueur_num_lancerfranc = (TextView) this.findViewById(R.id.tv_joueur_num_lancerfranc);
		tv_joueur_num_passdec = (TextView) this.findViewById(R.id.tv_joueur_num_passdec);
		tv_joueur_num_rebond = (TextView) this.findViewById(R.id.tv_joueur_num_rebond);
		tv_joueur_num_interc = (TextView) this.findViewById(R.id.tv_joueur_num_interc);
		tv_joueur_num_contr = (TextView) this.findViewById(R.id.tv_joueur_num_contr);
		tv_joueur_num_balperd = (TextView) this.findViewById(R.id.tv_joueur_num_balperd);
		tv_joueur_num_fautes = (TextView) this.findViewById(R.id.tv_joueur_num_fautes);
		tv_joueur_num_eval = (TextView) this.findViewById(R.id.tv_joueur_num_eval);
	}
	
	private void setupJoueurs() {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		LayoutInflater inflater = MainActivity.this.getLayoutInflater();
		final View dialogView = inflater.inflate(R.layout.dialog_creer_joueur, null);

		builder.setView(dialogView)
			.setPositiveButton("Créer", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					
					EditText et_nb_joueurs = (EditText) dialogView.findViewById(R.id.et_nb_joueurs);
					int nb_joueurs_a_creer = Integer.valueOf(et_nb_joueurs.getText().toString()); 
					if (nb_joueurs_a_creer > 0) {
						switch (0) {
						case 0:
							EditText et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur1);
							EditText et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur1);
							int num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							String nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur1 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 1;
							MainActivity.this.btn_joueur1.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur1.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur1.setEnabled(true);
							if (nb_joueurs_a_creer == 1)
								break;
						case 1:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur2);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur2);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur2 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 2;
							MainActivity.this.btn_joueur2.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur2.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur2.setEnabled(true);
							if (nb_joueurs_a_creer == 2)
								break;
						case 2:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur3);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur3);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur3 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 3;
							MainActivity.this.btn_joueur3.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur3.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur3.setEnabled(true);
							if (nb_joueurs_a_creer == 3)
								break;
						case 3:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur4);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur4);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur4 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 4;
							MainActivity.this.btn_joueur4.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur4.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur4.setEnabled(true);
							if (nb_joueurs_a_creer == 4)
								break;
						case 4:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur5);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur5);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur5 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 5;
							MainActivity.this.btn_joueur5.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur5.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur5.setEnabled(true);
							if (nb_joueurs_a_creer == 5)
								break;
						case 5:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur6);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur6);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur6 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 6;
							MainActivity.this.btn_joueur6.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur6.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur6.setEnabled(true);
							if (nb_joueurs_a_creer == 6)
								break;
						case 6:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur7);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur7);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur7 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 7;
							MainActivity.this.btn_joueur7.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur7.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur7.setEnabled(true);
							if (nb_joueurs_a_creer == 7)
								break;
						case 7:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur8);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur8);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur8 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 8;
							MainActivity.this.btn_joueur8.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur8.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur8.setEnabled(true);
							if (nb_joueurs_a_creer == 8)
								break;
						case 8:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur9);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur9);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur9 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 9;
							MainActivity.this.btn_joueur9.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur9.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur9.setEnabled(true);
							if (nb_joueurs_a_creer == 9)
								break;
						case 9:
							et_num_joueur = (EditText) dialogView.findViewById(R.id.et_num_joueur10);
							et_nom_joueur = (EditText) dialogView.findViewById(R.id.et_nom_joueur10);
							num_joueur = Integer.valueOf(et_num_joueur.getText().toString());
							nom_joueur = et_nom_joueur.getText().toString();
							MainActivity.this.joueur10 = new Joueur(num_joueur, nom_joueur);
							MainActivity.this.nb_joueurs = 10;
							MainActivity.this.btn_joueur10.setTextOn(""+num_joueur);
							MainActivity.this.btn_joueur10.setTextOff(""+num_joueur);
							MainActivity.this.btn_joueur10.setEnabled(true);
							// TODO Desactiver le menu Creer Joueur
//							MenuItem menu_creerjoueur = (MenuItem) MainActivity.this.findViewById(R.id.menu_creerJoueur);
//							menu_creerjoueur.setEnabled(false);
							if (nb_joueurs_a_creer == 10)
								break;
						default:
							break;
						}
					}
					Toast.makeText(MainActivity.this, "Appuyez sur un des joueurs pour finir la création", Toast.LENGTH_SHORT).show();
				}
			})
			.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
		
		builder.show();
		
//		joueur1 = new Joueur(4, "A");
//		joueur2 = new Joueur(5, "B");
//		joueur3 = new Joueur(6, "C");
//		joueur4 = new Joueur(7, "D");
//		joueur5 = new Joueur(8, "E");
//		joueur6 = new Joueur(9, "F");
//		joueur7 = new Joueur(10, "G");
//		joueur8 = new Joueur(11, "H");
//		joueur9 = new Joueur(12, "I");
//		joueur10 = new Joueur(15, "J");
//		btn_joueur10.setTextOn("15");
//		btn_joueur10.setTextOff("15");
		
	}
	
	public void deleteJoueur() {
		
		String[] listeJoueurs = new String[nb_joueurs]; 
		for (int i=1 ; i<=nb_joueurs ; i++) {
			switch (i) {
			case 1:
				listeJoueurs[0] = ""+joueur1.getNumero();
				break;
			case 2:
				listeJoueurs[1] = ""+joueur2.getNumero();
				break;
			case 3:
				listeJoueurs[2] = ""+joueur3.getNumero();
				break;
			case 4:
				listeJoueurs[3] = ""+joueur4.getNumero();
				break;
			case 5:
				listeJoueurs[4] = ""+joueur5.getNumero();
				break;
			case 6:
				listeJoueurs[5] = ""+joueur6.getNumero();
				break;
			case 7:
				listeJoueurs[6] = ""+joueur7.getNumero();
				break;
			case 8:
				listeJoueurs[7] = ""+joueur8.getNumero();
				break;
			case 9:
				listeJoueurs[8] = ""+joueur9.getNumero();
				break;
			case 10:
				listeJoueurs[9] = ""+joueur10.getNumero();
				break;
			default:
				break;
			}
		}
		
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder
			.setItems(listeJoueurs, new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO
				Toast.makeText(MainActivity.this, "Effacer le joueur "+which, Toast.LENGTH_SHORT).show();
			}})
			.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
		builder.show();
		
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it return
		// true, then it has handled the app icon touch event

		// Handle your other action bar item...
		switch (item.getItemId()) {
		case R.id.menu_undoLastAction:
			undoLastAction();
			return true;
		case R.id.menu_creerJoueur:
			setupJoueurs();
			return true;
		case R.id.menu_settings:
			deleteJoueur();
			return true;
		case R.id.menu_exit:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
    
    
    
    
    
    
    
    
    
    
}
