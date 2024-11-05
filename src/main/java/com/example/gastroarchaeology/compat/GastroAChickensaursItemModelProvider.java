package com.example.gastroarchaeology.compat;

import com.example.gastroarchaeology.Gastroarchaeology;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GastroAChickensaursItemModelProvider extends ItemModelProvider {
    public GastroAChickensaursItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Gastroarchaeology.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(GastroAChickensaurs.CHICKENSAUR_PACOCA.get());
    }
}
