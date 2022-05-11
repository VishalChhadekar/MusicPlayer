package com.vishal.MusicPlayer;

import java.util.*;

public class Album {
	private String name;
	private String artist;
	private ArrayList<Song> songs;

	public Album(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}

	public Album() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	public Song findSong(String title) {

		for (Song checkedSong : songs) {
			if (checkedSong.getTitle().equals(title))
				return checkedSong;
		}
		return null;
	}

	// methods
	public boolean addSong(String title, double duration) {
		if (findSong(title) == null) {
			songs.add(new Song(title, duration)); // creating new Song and passing title and duration
			return true;
		} else
			return false;

	}

//adding songs to playList based on the trackNumber
	public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber - 1; // setting index to zero, because trackNumber is 1
		if (index > 0 && index <= this.songs.size()) {// if index is in between 1 to size of songsList
			PlayList.add(this.songs.get(index)); // this will add the song to PlayList, at the particular index
			return true;

		} else
			System.out.println("No song found with this " + trackNumber + "trackNumber");
		return false;
	}

	// adding songs to playList based on the title
	public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
		for (Song checkedSong : this.songs) {
			if (checkedSong.getTitle().equals(title)) {// if the current song is present in the Album
				PlayList.add(checkedSong); // this will add then song to playList
				return true;
			}
		}
		System.out.println("No song found with this title, in the Album");
		return false;

	}

}
