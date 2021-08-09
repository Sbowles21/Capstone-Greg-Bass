package com.example.Capstone;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DexesIn implements Serializable {

    @Column
    Long poke_id;
    @Column
    Long dex_id;

    public DexesIn(Long poke_id, Long dex_id) {
        this.poke_id = poke_id;
        this.dex_id = dex_id;
    }
    public Long getPoke_id() {
        return poke_id;
    }

    public void setPoke_id(Long poke_id) {
        this.poke_id = poke_id;
    }

    public Long getDex_id() {
        return dex_id;
    }

    public void setDex_id(Long dex_id) {
        this.dex_id = dex_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DexesIn dexesIn = (DexesIn) o;
        return Objects.equals(poke_id, dexesIn.poke_id) && Objects.equals(dex_id, dexesIn.dex_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poke_id, dex_id);
    }
}
