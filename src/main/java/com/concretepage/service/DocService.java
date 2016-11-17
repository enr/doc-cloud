package com.concretepage.service;

import java.sql.SQLException;
import java.util.List;

import com.concretepage.model.Doc;

public interface DocService {
    public void updateDocument(Doc doca);

    public void deleteDocument(Doc doca);

    public List<Doc> searchDoc(Doc doca) throws SQLException;

}
