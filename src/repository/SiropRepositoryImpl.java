package repository;

import model.Sirop;

import java.util.ArrayList;
import java.util.List;

public class SiropRepositoryImpl implements SiropRepository {
    private final List<Sirop> siropList = new ArrayList<>();

    @Override
    public Sirop find(String denumire) {
        return siropList.stream()
                .filter(sirop -> sirop.getDenumire().equals(denumire))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Sirop> findAll() {
        return new ArrayList<>(siropList);
    }

    @Override
    public void update(Sirop sirop) {
        siropList.stream()
                .filter(s -> s.getDenumire().equals(sirop.getDenumire()))
                .findFirst()
                .ifPresent(existingSirop -> {
                    existingSirop.setPret(sirop.getPret());
                    existingSirop.setMililitri(sirop.getMililitri());
                    existingSirop.setDenumire(sirop.getDenumire());
                    existingSirop.setFurnizor(sirop.getFurnizor());
                    existingSirop.setStoc(sirop.getStoc());

                    //TODO
                });
    }

    @Override
    public void save(Sirop sirop) {
        siropList.add(sirop);
    }

    @Override
    public void delete(Sirop sirop) {
        siropList.removeIf(s -> s.getDenumire().equals(sirop.getDenumire()));
    }
}