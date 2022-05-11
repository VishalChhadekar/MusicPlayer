package com.vishal.MusicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class MainDriver {
//	private static final String Iterator = null;
	private static ArrayList<Album> albums = new ArrayList<>();
	// we have to add albums to this arrayList

	public static void main(String args[]) {
		Album album = new Album("Album1", "Maroon 5");
		album.addSong("Memories", 5.5);
		album.addSong("Girls Like You", 4.5);
		album.addSong("Don't wanna know", 5.49);
		album.addSong("Lost star", 3.89);
		albums.add(album);// adding album to ArrayList of Albums

		// new Album
		album = new Album("Album2", "Ed sheeran");

		album.addSong("Perfect", 3.49);
		album.addSong("Beutiful People", 4.5);
		album.addSong("Shape of you", 3.49);
		album.addSong("Drive", 3.49);

		albums.add(album);// adding album to ArrayList of Albums

		// create a linkedList to create playList
		LinkedList<Song> playList_1 = new LinkedList<>();
		albums.get(0).addToPlayList("Memories", playList_1);
		albums.get(0).addToPlayList("Girls Like You", playList_1);
		albums.get(0).addToPlayList("Don't wanna know", playList_1);
		albums.get(1).addToPlayList("Perfect", playList_1);
		albums.get(1).addToPlayList("Beutiful People", playList_1);
		albums.get(1).addToPlayList("Shape of you", playList_1);

//				// we have add two song from first Album and two songs from second Album to playList
		play(playList_1);

	}

	public static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		// checking whether playList is empty or not
		if (playList.size() == 0) {
			System.out.println("This playlist don't have any songs");
		} else {
			System.out.println("Now Playing " + listIterator.next().toString());
			displayMenu();
		}
		
		
		while (!stop) {// unless user hasn't stop, it will continue
			int input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 0:
				System.out.println("Completed");
				stop = true;
				break;

			case 1:
				if (!forward) {
					if (listIterator.hasNext()) {// if next song is available
						listIterator.next();// then, iterator will shift to next song
					}
					forward = true;
				}
				if (listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				} else {
					System.out.println("No song availble, list completed");
					forward = false;
				}
				break;
			case 2:
				if (forward) {
					if (listIterator.hasPrevious()) {// check if previous song is available
						listIterator.previous();// then set iterator to the previous song
					}
					forward = false;
				}
				if (listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());
				} else {
					System.out.println("First song");
					forward = false;
				}
				break;
			case 3:
				if (forward) {
					if (listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					} else {
						System.out.println("List completed");
					}
				} else {
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					} else {
						System.out.println("List completed");
					}
				}
				break;
			case 4:
				printList(playList);
				break;
			case 5:
				displayMenu();
				break;
			case 6:
				//delete a song
				if (playList.size() > 0) {
					listIterator.remove();
					if (listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
					} else {
						if (listIterator.hasPrevious())
							System.out.println("Now playing " + listIterator.previous().toString());
					}
				}
			}

		}


	}

	public static void displayMenu() {
		System.out.println("Available Options: \nChoose below");
		System.out.println("0 - Stop\n" + "1 - Next song\n" + "2 - Previous song\n" + "3 - Replay the current song\n"
				+ "4 - Display all playList \n" + "5 - Display all options\n" + "6 - Delete current song");
	}

	public static void printList(LinkedList<Song> PlayList) {
		Iterator<Song> iterator = PlayList.iterator();
		System.out.println("-----------------------------");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("-----------------------------");
	}

}
