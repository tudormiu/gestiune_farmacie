package repository;

import model.Medicament;

import java.util.ArrayList;
import java.util.List;

public class MedicamentRepositoryImpl implements MedicamentRepository {
    private List<Medicament> medicamentList = new ArrayList<>();

    @Override
    public Medicament find(String denumire) {
        return medicamentList.stream()
                .filter(medicament -> medicament.getDenumire().equals(denumire))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Medicament> findAll() {
        return new ArrayList<>(medicamentList);
    }

    @Override
    public void save(Medicament medicament) {
        medicamentList.add(medicament);
    }

    @Override
    public void update(Medicament medicament) {
        medicamentList.stream()
                .filter(m -> m.getDenumire().equals(medicament.getDenumire()))
                .findFirst()
                .ifPresent(existingMedicament -> {
                    //TODO
                });
    }

    @Override
    public void delete(Medicament medicament) {
        medicamentList.removeIf(m -> m.getDenumire().equals(medicament.getDenumire()));
    }
}