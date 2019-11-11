package org.wahlzeit.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.google.appengine.api.images.Image;

public class BikePhotoManager extends PhotoManager {

    protected static final BikePhotoManager instance = new BikePhotoManager();

    private static final Logger log = Logger.getLogger(BikePhotoManager.class.getName());

    protected Map<PhotoId, BikePhoto> photoCache = new HashMap<PhotoId, BikePhoto>();

    protected PhotoTagCollector photoTagCollector = null;

    public BikePhotoManager() {
        photoTagCollector = BikePhotoFactory.getInstance().createPhotoTagCollector();
    }

    public static final BikePhotoManager getInstance() {
        return instance;
    }

 
    public BikePhoto getPhotoFromId(PhotoId id) {
        if (id == null) {
            return null;
        }

        BikePhoto result = doGetPhotoFromId(id);

        if (result == null) {
            result = BikePhotoFactory.getInstance().loadPhoto(id);
            if (result != null) {
                doAddPhoto(result);
            }
        }

        return result;
    }

    protected BikePhoto doGetPhotoFromId(PhotoId id) {
        return this.photoCache.get(id);
    }

    public void addPhoto(BikePhoto photo) throws IOException {
		PhotoId id = photo.getId();
		assertIsNewPhoto(id);
		doAddPhoto(photo);

		GlobalsManager.getInstance().saveGlobals();
	}

    protected void doAddPhoto(BikePhoto myPhoto) {
        photoCache.put(myPhoto.getId(), myPhoto);
    }

	public BikePhoto getVisiblePhoto(PhotoFilter filter) {
		filter.generateDisplayablePhotoIds();
		return getPhotoFromId(filter.getRandomDisplayablePhotoId());
	}

    public BikePhoto createPhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		BikePhoto result = (BikePhoto) PhotoUtil.createPhoto(filename, id, uploadedImage);
		addPhoto(result);
		return result;
	}

}
