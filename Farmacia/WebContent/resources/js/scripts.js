    function verificar(xhr, status, args, dlg, tb) {
        if(args.validationFailed) {
            PF(dlg).jq.effect("shake", {times:15}, 50);
        }
        else {
            PF(dlg).hide();
            PF(tb).clearFilters(); //teste
        }
    }