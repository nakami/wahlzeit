package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class BikeType extends DataObject {

    private BikeType superType = null;
    private Set<BikeType> subTypes = new HashSet<BikeType>();
    private String typeName;

    public BikeType(String bikeTypeName) {
        this.typeName = bikeTypeName;
    }

    public String getName() {
        return this.typeName;
    }

    public Bike createInstance() {
        return new Bike(this);
    }

    public void setSuperType(BikeType superType) {
        this.superType = superType;
    }

    public BikeType getSuperType() {
        return this.superType;
    }

    public Iterator<BikeType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(BikeType biketype) {
        assert(biketype != null): "tried to set null sub-type";
        biketype.setSuperType(this);
        subTypes.add(biketype);
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

    public boolean isSubtypeOf(BikeType biketype){
        return this.getSuperType() == biketype;
    }

    public boolean isSupertypeOf(BikeType biketype){
        return biketype.getSuperType() == this;
    }
}