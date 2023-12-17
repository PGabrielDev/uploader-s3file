package com.pggm.s3.imageupload.useCases.interfaces;

import java.io.IOException;

public interface UseCaseIN <IN> {
    void execute(IN input) throws IOException;
}
