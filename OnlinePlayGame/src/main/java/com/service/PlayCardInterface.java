package com.service;

import java.util.List;

import com.Model.PlayCard;
import com.exception.PlayCardException;

public interface PlayCardInterface {
	public PlayCard AddPlayCard(PlayCard game) throws PlayCardException;
	public PlayCard UpdateDiscount(int gid,int discount) throws PlayCardException ;
	public PlayCard updatePlaycard( PlayCard game) throws PlayCardException;
	public PlayCard DeletePlaycard(int gid) throws PlayCardException ;
	public List<PlayCard> getAllPlaycards();
}
