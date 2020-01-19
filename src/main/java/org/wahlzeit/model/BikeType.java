package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class BikeType extends DataObject {

    protected BikeType superType = null;
    protected Set<BikeType> subTypes = new HashSet<BikeType>();
    protected String typeName;
    
    public String[] bikeTypeNames = {
        null,
        "CITYBIKE",
        "RACINGBIKE",
        "MOUNTAINBIKE",
        "MISCELLANEOUS",
        "UNKNOWN"
    };

    public BikeType(String bikeTypeName) {
        this.typeName = bikeTypeName;
    }

    public String getName() {
        return this.typeName;
    }

    public Bike createInstance() {
        return new Bike(this);
    }

    public void setSuperType(BikeType st) {
        superType = st;
    }

    public BikeType getSuperType() {
        return superType;
    }

    public Iterator<BikeType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(BikeType bt) {
        assert(bt != null): "tried to set null sub-type";
        bt.setSuperType(this);
        subTypes.add(bt);
    }

    public boolean hasInstance(Bike bike) {
        assert(bike != null): "asked about null object";
        if (bike.getType() == this) {
            return true;
        }
        for (BikeType type : subTypes) {
            if (type.hasInstance(bike)) {
                return true;
            }
        }
        return false;
    }
}