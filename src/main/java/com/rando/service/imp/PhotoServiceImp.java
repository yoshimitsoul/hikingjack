package com.rando.service.imp;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rando.dao.EtapeRepository;
import com.rando.dao.PhotoRepository;
import com.rando.modele.Etape;
import com.rando.modele.Photo;
import com.rando.service.PhotoService;

@Service
@Transactional
public class PhotoServiceImp implements PhotoService{

	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	EtapeRepository etapeRepository;
	
	@Override
	public List<Photo> getAllPhotosByIdEtape(int idEtape){

		List<Photo> getPhotos = photoRepository.findByEtapeId(idEtape);
		
		for(Photo p : getPhotos) {
			String urlToGet = p.getUrlPhoto();
			int indexLastSlash = urlToGet.lastIndexOf("/");
			String realUrl = p.getUrlPhoto().substring(indexLastSlash);
			p.setUrlPhoto("/photoService" + realUrl);

			System.out.println(realUrl);
			System.out.println(p.getUrlPhoto());
		}
		return getPhotos; 
	}
	
	@Override
	public void savePhotosWithEtape(String urlPhoto ,int idEtape) {
		Photo photoAAJouter = new Photo();
		Optional<Etape> getEtapePhoto = etapeRepository.findById(idEtape);
		Etape etapePhoto = null;
		if(!getEtapePhoto.isEmpty()) {
			etapePhoto = getEtapePhoto.get();
		}else {
			throw new NoSuchElementException();
		}
		
		photoAAJouter.setUrlPhoto(urlPhoto);
		photoAAJouter.setEtapePhoto(etapePhoto);
		photoRepository.save(photoAAJouter);
	}
}
