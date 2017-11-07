package mx.com.clickapuntos.util;

import java.util.ArrayList;
import java.util.List;

import mx.com.clickapuntos.persistence.Promos;

public class ArmaSlider {
	public String getItemSlider(List<Promos> listaPromos, String context){
		StringBuffer elemSlider = new StringBuffer();
		if(listaPromos == null || listaPromos.size() < 1){
			return "";
		}
		
		for(Promos promo: listaPromos){
			elemSlider.append("<div class=\"slider_item\">")
				.append(" <div class=\"slider_item_img\">")
				.append("<img src=\""+context+"/imagenes-promos/")
				.append(promo.getPromoimagen())
				.append("\" alt=\"slider\" />")
				.append("</div>")
				.append("<div class=\"slider_item_button\">")
				.append("<a href=\"")
				.append("#")
				.append("\">")
				.append("<img src=\"")
				.append("/images/play.png")
				.append("\" alt=\"Reproducir video\" /></a>")
				.append("<img src=\"")
				.append("/images/participa.png")
				.append("\" alt=\"Participa\" /></a>")
				.append("</div> </div>")
				.append("");
		}
		
		System.out.println(elemSlider.toString());
		return elemSlider.toString();
	}
	
	public static void main(String[] args) {
		Promos promo = new Promos();
		promo.setPromomecanicaimagen("1.jpg");
		List<Promos> lista = new ArrayList<Promos>();
		lista.add(promo);
		ArmaSlider slider = new ArmaSlider();
		slider.getItemSlider(lista,"");
	}
}	
